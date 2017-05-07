package com.pls.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.omg.IOP.CodecPackage.FormatMismatch;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.bean.VehicleType;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;

public class ParkingImpl implements ParkingSystem {
	
	@Override
	public Map<ParkingSlot, List<Vehicle>> parkVehicle(String fileVehicle,
			String fileParkingSlot) throws ParkingFullException {
		Map<ParkingSlot, List<Vehicle>> ma=new HashMap<ParkingSlot, List<Vehicle>>();
		List<Vehicle>li=new ArrayList<Vehicle>();
		Scanner s=null;
		ParkingSlot parkingSlot=null;
		 try {
			s=new Scanner(new File(fileVehicle));
			while(s.hasNext()){
			String line=s.nextLine();
			String data[]=line.split("-");
			int vehicleId=Integer.parseInt(data[0].trim());
			 String vehicleType=data[1].trim();
			 int price=0;
			 
			 li.add(new Vehicle(vehicleId, VehicleType.valueOf(vehicleType), price));
			}
			
			s=new Scanner(new File(fileParkingSlot));
			while(s.hasNext()){
				String line=s.nextLine();
				String data[]=line.split(":");
				int slotLaneNo=Integer.parseInt(data[1].trim());
				int price=Integer.parseInt(data[1].trim());
				
				parkingSlot=new ParkingSlot(slotLaneNo, price);
				ma.put(parkingSlot, li);
			}
			for (Vehicle vehicle : li) {
				if(vehicle.getVehicleType().equals(VehicleType.Bike)){
					vehicle.setPrice(20);
				}
				else if(vehicle.getVehicleType().equals(VehicleType.Car)){
					vehicle.setPrice(40);
				}
				else if(vehicle.getVehicleType().equals(VehicleType.Bus)){
					vehicle.setPrice(60);
				}
				else if(vehicle.getVehicleType().equals(VehicleType.Truck)){
					vehicle.setPrice(80);
				}
				
			}
            Set<Map.Entry<ParkingSlot, List<Vehicle>>>set=ma.entrySet();
            int i=0;
			for (Vehicle vehicle : li) {
				for (Entry<ParkingSlot, List<Vehicle>> entry : set) {
					for ( i = entry.getValue().size(); i <4; i++) {
						entry.getValue().add(vehicle);
					}
					
					
				}

				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//System.out.println(ma);
		return ma;
		
		
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
