package com.psl.bean;

import java.io.Serializable;

public class Usage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4910426392378899646L;
	private String channelId;
	private int startTime;//in hundred hours format
	private int endTime;//in hundred hours format
	
	
	
	
	@Override
	public String toString() {
		return "Usage [channelId=" + channelId + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	public Usage(String channelId, int startTime, int endTime) {
		super();
		this.channelId = channelId;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
	
	
}
