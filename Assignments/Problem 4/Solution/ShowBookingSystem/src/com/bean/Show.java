package com.bean;

import java.io.Serializable;

public class Show implements Serializable {

	public Show(String showName, String showTime, int seatsAvailable) {
		super();
		this.showName = showName;
		this.showTime = showTime;
		this.seatsAvailable = seatsAvailable;
	}
	private static final long serialVersionUID = 1L;
	private String showName;
	private String showTime;
	private int seatsAvailable;	
	
	
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	@Override
	public String toString() {
		return "Show [showName=" + showName + ", showTime=" + showTime
				+ ", seatsAvailable=" + seatsAvailable + "]";
	}	
}
