package com.psl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.INPUT_STREAM;

import com.psl.bean.Destination;
import com.psl.bean.Ship;

public class ShipyardSystemImpl implements ShipyardSystem {

	@Override
	public List<Ship> populateData(String fileName) {
		
		List<Ship> list=new ArrayList<Ship>();
		ObjectInputStream inputStream=null;
 		try {
			
			inputStream=new ObjectInputStream(new FileInputStream(new File(fileName)));
			
			while (true) {
				list.add((Ship)inputStream.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	

	@Override
	public void calculateEndDate(String locationFile, List<Ship> list) {
		
//		List<Destination> listDestination=new ArrayList<Destination>();
		Map<String,Integer> mapDest=new HashMap<String, Integer>();
		
		ObjectInputStream inputStream=null;
 		try {
			inputStream=new ObjectInputStream(new FileInputStream(new File(locationFile)));	
			while (true) {
				Destination destination=(Destination)inputStream.readObject();
				mapDest.put(destination.getDestinationName(), destination.getNumberOfDays());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
//		System.out.println(mapDest);
		
		for (Ship ship : list) {
			Calendar cal=Calendar.getInstance();
			cal.setTime(ship.getStartDate());
			cal.add(Calendar.DAY_OF_YEAR,mapDest.get(ship.getDestinationName()));
			ship.setEndDate(cal.getTime());
			ship.setNumberOfDays(mapDest.get(ship.getDestinationName()));
		}
	}

	@Override
	public void sortByLongestJourney(List<Ship> list) {
		for (Ship ship : list) {
			long start=ship.getStartDate().getTime();
			long end=ship.getEndDate().getTime();
			
			int numberOfDays=(int )((end-start)/(24*60*60*1000));
			ship.setNumberOfDays(numberOfDays);
			
		}
		
		Collections.sort(list,new Comparator<Ship>() {

			@Override
			public int compare(Ship s1, Ship s2) {
				return s2.getNumberOfDays()-s1.getNumberOfDays();
			}
		});
	}

	@Override
	public void calculateCost(List<Ship> list) {
		
		sortByLongestJourney(list);
		for (Ship ship : list) {
			int numberOfDays=ship.getNumberOfDays();
			if(numberOfDays>100){
				int total=(numberOfDays-100)*70;
				ship.setTotalCost(total+(100*100));
			}
			else
			{
				ship.setTotalCost(ship.getNumberOfDays()*100);
			}
		}
		
	}

	
	

}
