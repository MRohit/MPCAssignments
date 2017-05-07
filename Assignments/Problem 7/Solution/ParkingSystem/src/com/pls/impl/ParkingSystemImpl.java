package com.pls.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.bean.VehicleType;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;

public class ParkingSystemImpl implements ParkingSystem {

	@Override
	public Map<ParkingSlot, List<Vehicle>> parkVehicle(String fileVehicle,
			String fileParkingSlot) throws ParkingFullException {

		Map<ParkingSlot, List<Vehicle>> map = new HashMap<ParkingSlot, List<Vehicle>>();
		Set<Map.Entry<ParkingSlot, List<Vehicle>>> set = map.entrySet();

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileParkingSlot));
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split(":");

				int slotLaneNo = Integer.parseInt(temp[0].trim());
				int price = Integer.parseInt(temp[1].trim());

				map.put(new ParkingSlot(slotLaneNo, price),
						new ArrayList<Vehicle>());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanner.close();

		List<Vehicle> listVehicle = new ArrayList<Vehicle>();
		try {
			scanner = new Scanner(new File(fileVehicle));
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split("-");
				int vehicleId = Integer.parseInt(temp[0]);
				VehicleType vehicleType = VehicleType.valueOf(temp[1].trim());
				listVehicle.add(new Vehicle(vehicleId, vehicleType, 0));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scanner.close();

		for (Vehicle vehicle : listVehicle) {
			if (vehicle.getVehicleType().equals(VehicleType.Bike)) {
				vehicle.setPrice(20);
				continue;
			}

			if (vehicle.getVehicleType().equals(VehicleType.Bus)) {
				vehicle.setPrice(60);
				continue;
			}

			if (vehicle.getVehicleType().equals(VehicleType.Truck)) {
				vehicle.setPrice(50);
				continue;
			}

			if (vehicle.getVehicleType().equals(VehicleType.Car)) {
				vehicle.setPrice(40);
			}
		}
		System.out.println(listVehicle.size());
		int count=0;
		for (Vehicle vehicle : listVehicle) {
			for (Entry<ParkingSlot, List<Vehicle>> entry : set) {
				if(vehicle.getPrice()==entry.getKey().getPrice()){
					if(entry.getValue().size()<4){
						entry.getValue().add(vehicle);
						count++;
						break;
					}
				}
			}
		}

		if(!(count==listVehicle.size())){
			try{
			throw new ParkingFullException();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		

		return map;
	}

	@Override
	public List<Vehicle> getVehicleInLane(Map<ParkingSlot, List<Vehicle>> map,
			int slotLaneNo) {

		Set<Map.Entry<ParkingSlot, List<Vehicle>>> set = map.entrySet();
		for (Entry<ParkingSlot, List<Vehicle>> entry : set) {
			if (entry.getKey().getSlotLaneNo() == slotLaneNo) {
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public int locateVehicle(Map<ParkingSlot, List<Vehicle>> map, int vehicleId)
			throws VehicleNotFoundException {

		Set<Map.Entry<ParkingSlot, List<Vehicle>>> set = map.entrySet();
		for (Entry<ParkingSlot, List<Vehicle>> entry : set) {
			for (Vehicle vehicle : entry.getValue()) {
				if (vehicle.getVehicleId() == vehicleId) {
					return entry.getKey().getSlotLaneNo();
				}
			}
		}
		throw new VehicleNotFoundException();

	}

	@Override
	public Vehicle removeVehicle(Map<ParkingSlot, List<Vehicle>> map,
			int vehicleId) throws VehicleNotFoundException {

		Set<Map.Entry<ParkingSlot, List<Vehicle>>> set = map.entrySet();
		for (Entry<ParkingSlot, List<Vehicle>> entry : set) {
			Iterator<Vehicle> iterator = entry.getValue().iterator();
			while (iterator.hasNext()) {
				Vehicle vehicle = iterator.next();
				if (vehicle.getVehicleId() == vehicleId) {
					iterator.remove();
					return vehicle;
				}
			}
		}
		throw new VehicleNotFoundException();
	}

}
