package com.util;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.exception.CityNotFoundException;
import com.exception.InvalidStateException;

public interface DataManager {
	Map<String,List<String>> populateCityDataMap(String fileName)throws FileNotFoundException;
	List<String> getCities(Map<String,List<String>> stateCityMap,String state) throws  InvalidStateException;
	String getState(Map<String,List<String>> stateCityMap,String city)throws CityNotFoundException;	
	
}
