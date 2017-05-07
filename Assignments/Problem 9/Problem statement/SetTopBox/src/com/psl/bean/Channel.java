package com.psl.bean;

import java.io.Serializable;

public class Channel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2640065012494322364L;
	private String channelId;
	private String channelName;
	private ChannelCategory category;
	private double cost;
	private double billAmount;
	private double hourOfUsage;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName="
				+ channelName + ", category=" + category + ", cost=" + cost
				+ ", billAmount=" + billAmount + ", hourOfUsage=" + hourOfUsage
				+ "]";
	}
	
	
	public Channel(String channelId, String channelName,
			ChannelCategory category, double cost, double billAmount,
			double hourOfUsage) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.category = category;
		this.cost = cost;
		this.billAmount = billAmount;
		this.hourOfUsage = hourOfUsage;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public ChannelCategory getCategory() {
		return category;
	}
	public void setCategory(ChannelCategory category) {
		this.category = category;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public void setHourOfUsage(double hourOfUsage) {
		this.hourOfUsage = hourOfUsage;
	}
	public double getHourOfUsage() {
		return hourOfUsage;
	}

	
	
	
}
