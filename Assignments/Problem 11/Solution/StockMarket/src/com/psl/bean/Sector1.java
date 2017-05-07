package com.psl.bean;

import java.util.List;

public class Sector1 {

	private Sector sectorType;
	private int totalCost;
	private double totalNumberOfShares;
	private List<Stock> list;
	
	
	public Sector getSectorType() {
		return sectorType;
	}
	public void setSectorType(Sector sectorType) {
		this.sectorType = sectorType;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public double getTotalNumberOfShares() {
		return totalNumberOfShares;
	}
	public void setTotalNumberOfShares(double totalNumberOfShares) {
		this.totalNumberOfShares = totalNumberOfShares;
	}
	public List<Stock> getList() {
		return list;
	}
	public void setList(List<Stock> list) {
		this.list = list;
	}
	
	
	
	
}
