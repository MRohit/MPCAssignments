package com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;


// Override and implement the methods of Interface DataManager here 
public class DataManagerImpl implements DataManager {

	@Override
	public Map<String, List<String>> populateCityDataMap(String fileName)
			throws FileNotFoundException {
		Map<String, List<String>> m=new HashMap<String, List<String>>();
		File f=new File(fileName);
		Scanner scr=new Scanner(f);
		String record;
		String []data;
		
		while(scr.hasNext()){
			record=scr.nextLine();
			//System.out.println(record);
			data=record.split("-");
			
			
			if(m.containsKey(data[0].trim())){
				System.out.println("Map:"+m.get(data[0].trim()));
				m.get(data[0].trim()).add(data[1].trim());
				//ls.add(data[1]);
				
			}else{
				List<String> ls=new ArrayList<String>();
				ls.add(data[1].trim());
				m.put(data[0].trim(), ls);
			}
			//m.put(data[0], ls);
		}
		return m;
	}

	@Override
	public List<String> getCities(Map<String, List<String>> stateCityMap,
			String state) throws InvalidStateException {
		 if(stateCityMap.containsKey(state.trim())){
			System.out.println("Cities:"+stateCityMap.get(state.trim()));
			
			//ls.add(data[1]);
		 }else
			 throw new InvalidStateException();
		
	
		return null;
	}

	@Override
	public String getState(Map<String, List<String>> stateCityMap, String city)
			throws CityNotFoundException {
		boolean foundflag = false;
		Set<String> state=stateCityMap.keySet();
		String st=null;
		Iterator<String> itr=state.iterator();
		while(itr.hasNext()){
			st=itr.next();
			List<String> list=stateCityMap.get(st);
			if(list.contains(city)){
				foundflag=true;
				break;
			}
			
		}
		if(foundflag=false)
			throw new CityNotFoundException();
		return st;
	}

}
