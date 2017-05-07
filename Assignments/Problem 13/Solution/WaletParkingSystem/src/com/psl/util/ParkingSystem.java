package com.psl.util;

import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.ParkingBlock;
import com.psl.exception.ParkingFullException;

public interface ParkingSystem {

	Set<ParkingBlock> populateData(String fileName);//sort by vehicle number in ascending order
	ParkingBlock removeVehicle(Set<ParkingBlock> treeSet,int vehicleNumber,int outitme);//return the parking block whose vehicle is removed
	Set<ParkingBlock> sortByParkingTime(Set<ParkingBlock> treeSet);//sort data by total duration of vehicle in parking
	void parkVehicle(Set<ParkingBlock> set,int vehicleNumber,int parkTime)throws ParkingFullException;//where vehicle number is not given means that block is empty.If no place availble than throw ParkingFullException
}
