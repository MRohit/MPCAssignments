package com.psl.bean;

import java.io.Serializable;
import java.util.Date;

public class Ship implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4539567133395318476L;
	private int shipNumber;
	private String destinationName;
	private Date startDate;
	private Date endDate;
	private double totalCost;
	private int numberOfDays;
	
	
	
	
	
	@Override
	public String toString() {
		return "Ship [shipNumber=" + shipNumber + ", destinationName="
				+ destinationName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", totalCost=" + totalCost + ", numberOfDays="
				+ numberOfDays + "]";
	}
	public int getShipNumber() {
		return shipNumber;
	}
	public void setShipNumber(int shipNumber) {
		this.shipNumber = shipNumber;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	
	
	
	
}
