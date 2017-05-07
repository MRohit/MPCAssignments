package com.pls.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.exception.ParkingFullException;
import com.pls.impl.ParkingImpl;
import com.pls.impl.ParkingSysImpl;

public class Cli {
	public static void main(String[] args) {

		ParkingImpl p=new ParkingImpl();
		try {
			Map<ParkingSlot, List<Vehicle>>map=new HashMap<ParkingSlot, List<Vehicle>>();
			map=p.parkVehicle("Vehicle.txt","ParkingSlot.txt");
			System.out.println(map);
		} catch (ParkingFullException e) {
			e.printStackTrace();
		}
}
}
