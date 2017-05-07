package com.psl.main;

import java.util.Set;

import com.psl.bean.ParkingBlock;
import com.psl.exception.ParkingFullException;
import com.psl.util.ParkingSystemImpl;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ParkingSystemImpl impl=new ParkingSystemImpl();
		Set<ParkingBlock> set=impl.populateData("walletParking.txt");
		System.out.println(set.size());
		for (ParkingBlock parkingBlock : set) {
			System.out.println(parkingBlock);
		}
		
		
//		System.out.println("\n\n\n\n\n");
//		Set<ParkingBlock> set2=impl.sortByParkingTime(set);
//		for (ParkingBlock parkingBlock : set2) {
//			System.out.println(parkingBlock.getParkTime()+"\t"+parkingBlock.getBlockNumber());
//		}
		
		
		System.out.println("\n\n\n\n\n");
		try {
			impl.parkVehicle(set, 2099,2300);
			impl.parkVehicle(set, 2099,2300);
			impl.parkVehicle(set, 2099,2300);
//			impl.parkVehicle(set, 2099,2300);
			for (ParkingBlock parkingBlock : set) {
				System.out.println(parkingBlock.getParkTime()+"\t"+parkingBlock.getBlockNumber());
			}
		} catch (ParkingFullException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n\n\n\n");
		System.out.println(impl.removeVehicle(set,2015,1700));
		for (ParkingBlock parkingBlock : set) {
			System.out.println(parkingBlock);
		}
		
		
	}
}
