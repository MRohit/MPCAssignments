package com.psl;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;
import com.util.DataManagerImpl;


public class Client {
	
	public static void main(String[] args) throws InvalidStateException {
		//Call your methods from here  to test the code implemented
		DataManagerImpl d=new DataManagerImpl();
		Map<String, List<String>> m=new HashMap<String, List<String>>();
		try {
			m=d.populateCityDataMap("StateCityDetails.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			d.getCities(m, "Maharashtra");
		}  catch (InvalidStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(d.getState(m, "Pune"));
		} catch (CityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}