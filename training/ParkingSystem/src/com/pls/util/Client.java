package com.pls.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.exception.ParkingFullException;
import com.pls.impl.ParkingSystemImpl;


public class Client {

	public static void main(String[] args) {

		ParkingSystemImpl impl=new ParkingSystemImpl();
		try {
			Map<ParkingSlot, List<Vehicle>> map=impl.parkVehicle("Vehicle.txt","ParkingSlot.txt");
			Set<Map.Entry<ParkingSlot,List<Vehicle>>> set=map.entrySet();
			
			
			System.out.println("\n\n\n\n\n");
//			System.out.println(set.size());
			for (Entry<ParkingSlot, List<Vehicle>> entry : set) {
				System.out.println(entry.getKey());
				System.out.println(entry.getValue().size());
			}
			
		} catch (ParkingFullException e) {
			e.printStackTrace();
		}
		
	}

}