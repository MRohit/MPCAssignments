package com.pls.bean;

public class Vehicle {

	private int vehicleId;
	private VehicleType vehicleType;
	private int price;
	
	

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType="
				+ vehicleType + ", price=" + price + "]"+"\n";
	}
	
	

	public Vehicle(int vehicleId, VehicleType vehicleType, int price) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.price = price;
	}



	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	
}
