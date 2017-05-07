package com.psl.main;

import java.text.SimpleDateFormat;
import java.util.List;

import com.psl.bean.Ship;
import com.psl.util.ShipyardSystemImpl;

public class Client {

	public static void main(String[] args) {
		
		ShipyardSystemImpl impl=new ShipyardSystemImpl();
		List<Ship> list=impl.populateData("ship.ser");
		for (Ship ship : list) {
			System.out.println(ship);
		}
		
		System.out.println("\n\n\n\n");
		impl.calculateEndDate("destination.ser", list);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for (Ship ship : list) {
			System.out.println(ship.getNumberOfDays()+"\t"+ship.getStartDate()+"\t"+sdf.format(ship.getEndDate()));
		}
		
		
		
		System.out.println("\n\n\n\n");
		impl.sortByLongestJourney(list);
	
		for (Ship ship : list) {
			System.out.println(ship.getNumberOfDays());
		}
		

		System.out.println("\n\n\n\n");
		impl.calculateCost(list);
	
		for (Ship ship : list) {
			System.out.println(ship.getNumberOfDays()+"\t"+ship.getTotalCost());
		}
		
	}

}
