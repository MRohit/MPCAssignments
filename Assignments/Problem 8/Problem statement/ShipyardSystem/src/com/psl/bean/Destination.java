package com.psl.bean;

import java.io.Serializable;

public class Destination implements Serializable{

	
	private static final long serialVersionUID = 2859716801954438991L;
	private String destinationName;
	private int numberOfDays;
	
	
	
	
	
	@Override
	public String toString() {
		return "Destination [destinationName=" + destinationName
				+ ", numberOfDays=" + numberOfDays + "]";
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	
	
	
	
}
