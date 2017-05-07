package com.pls.impl;

import java.util.List;
import java.util.Map;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;

public interface ParkingSystem {
	Map<ParkingSlot,List<Vehicle>> parkVehicle(String fileVehicle,String fileParkingSlot) throws ParkingFullException;
	List<Vehicle> getVehicleInLane(Map<ParkingSlot,List<Vehicle>> map,int slotLaneNo);
	int locateVehicle(Map<ParkingSlot,List<Vehicle>> map,int vehicleId)throws VehicleNotFoundException;
	Vehicle removeVehicle(Map<ParkingSlot,List<Vehicle>> map,int vehicleId) throws VehicleNotFoundException;
		
}
