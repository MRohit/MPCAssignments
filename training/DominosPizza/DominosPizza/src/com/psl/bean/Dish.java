package com.psl.bean;

import java.util.List;

public class Dish {

	private int dishId;
	private String dishName;
	private double cost;
	private double timeToCook;
	private List<Location> list;
		
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Dish(int dishId, String dishName, double cost, double timeToCook) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.cost = cost;
		this.timeToCook = timeToCook;
		this.list = list;
	}
	public double getCost() {
		return cost;
	}
	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", cost="
				+ cost + ", timeToCook=" + timeToCook + ", list=" + list + "]\n";
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getTimeToCook() {
		return timeToCook;
	}
	public void setTimeToCook(double timeToCook) {
		this.timeToCook = timeToCook;
	}
	public List<Location> getList() {
		return list;
	}
	public void setList(List<Location> list) {
		this.list = list;
	}
	
	
	
	
}
