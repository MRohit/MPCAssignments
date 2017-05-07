package com.psl.bean;

public class Order {

	private int dishId;
	private int locationCode;
	private double totalCost;
	
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public Order() {
		
	}
	public Order(int dishId, int locationCode) {
		super();
		this.dishId = dishId;
		this.locationCode = locationCode;
	}
	@Override
	public String toString() {
		return "Order [dishId=" + dishId + ", locationCode=" + locationCode
				+ ", totalCost=" + totalCost + "]\n";
	}
	public int getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
