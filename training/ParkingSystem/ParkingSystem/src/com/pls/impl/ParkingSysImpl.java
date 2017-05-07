package com.pls.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.bean.VehicleType;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;

public class ParkingSysImpl implements ParkingSystem {

	@Override
	public Map<ParkingSlot, List<Vehicle>> parkVehicle(String fileVehicle,
			String fileParkingSlot) throws ParkingFullException {
		Map<ParkingSlot, List<Vehicle>>parkingMap=new HashMap<ParkingSlot, List<Vehicle>>();
		Scanner s=null;
		try {
			 s=new Scanner(new File(fileParkingSlot));
			 
			 while(s.hasNext())
			 {
				 String data[]=s.nextLine().split(":");
				 int slotNo=Integer.parseInt(data[0]);
				 int price=Integer.parseInt(data[1]);
				 parkingMap.put(new ParkingSlot(slotNo, price), new ArrayList<Vehicle>());
			 }
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			s.close();
		}
		List<Vehicle>listVehicle=new ArrayList<Vehicle>();
		
		try {
			s=new Scanner(new File(fileVehicle));
			
			while(s.hasNext())
			{
				String data[]=s.nextLine().split("-");
				int vehicleId=Integer.parseInt(data[0]);
				VehicleType vehicleType =VehicleType.valueOf(data[1]);
				int price=0;
				
				listVehicle.add(new Vehicle(vehicleId, vehicleType, price));
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}finally{
			s.close();
		}
		for (Vehicle vehicle : listVehicle) {
			if(vehicle.getVehicleType().equals(VehicleType.Bike)){
				vehicle.setPrice(20);
				
			}
			if(vehicle.getVehicleType().equals(VehicleType.Car)){
				vehicle.setPrice(40);
				
			}
			if(vehicle.getVehicleType().equals(VehicleType.Bus)){
				vehicle.setPrice(60);
				
			}
			if(vehicle.getVehicleType().equals(VehicleType.Truck)){
				vehicle.setPrice(80);
				
			}
			
		}
		Vehicle vehicle = null;
		if(listVehicle.size()<4){
			listVehicle.add(vehicle);
		}
		
	
		return null;
	}

	@Override
	public List<Vehicle> getVehicleInLane(Map<ParkingSlot, List<Vehicle>> map,
			int slotLaneNo) {
		
		
		return null;
	}

	@Override
	public int locateVehicle(Map<ParkingSlot, List<Vehicle>> map, int vehicleId)
			throws VehicleNotFoundException {
		return 0;
	}

	@Override
	public Vehicle removeVehicle(Map<ParkingSlot, List<Vehicle>> map,
			int vehicleId) throws VehicleNotFoundException {
		return null;
	}
	
	

}
