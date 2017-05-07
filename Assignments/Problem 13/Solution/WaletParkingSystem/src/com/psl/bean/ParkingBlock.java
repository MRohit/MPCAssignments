package com.psl.bean;

public class ParkingBlock {

	private int blockNumber;
	private int vehicleNumber;
	private int parkTime;
	private int outTime;
	private double charge;
	
	
	@Override
	public String toString() {
		return "ParkingBlock [blockNumber=" + blockNumber + ", vehicleNumber="
				+ vehicleNumber + ", parkTime=" + parkTime + ", outTime="
				+ outTime + ", charge=" + charge + "]";
	}
	public ParkingBlock(int blockNumber, int vehicleNumber, int parkTime,
			int outTime, double charge) {
		super();
		this.blockNumber = blockNumber;
		this.vehicleNumber = vehicleNumber;
		this.parkTime = parkTime;
		this.outTime = outTime;
		this.charge = charge;
	}
	public int getBlockNumber() {
		return blockNumber;
	}
	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getParkTime() {
		return parkTime;
	}
	public void setParkTime(int parkTime) {
		this.parkTime = parkTime;
	}
	public int getOutTime() {
		return outTime;
	}
	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	
	
}
