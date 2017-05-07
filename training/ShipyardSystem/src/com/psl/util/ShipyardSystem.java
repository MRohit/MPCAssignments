package com.psl.util;

import java.util.List;

import com.psl.bean.Ship;

public interface ShipyardSystem {

	List<Ship> populateData(String fileName);
	void calculateEndDate(String locationFile,List<Ship> list);
	void sortByLongestJourney(List<Ship> list);//sort in descending order of journey days taken(means descending order of journey time)
	void calculateCost(List<Ship> list);//100.Rs for first 1000 km and 70.Rs after 1000 km.
	
}
