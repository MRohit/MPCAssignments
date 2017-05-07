package com.pls.bean;

public class ParkingSlot {
	private int slotLaneNo;
	private int price;

	
	@Override
	public String toString() {
		return "ParkingSlot [slotLaneNo=" + slotLaneNo + ", price=" + price
				+ "]"+"\n";
	}

	public ParkingSlot(int slotLaneNo, int price) {
		super();
		this.slotLaneNo = slotLaneNo;
		this.price = price;
	}

	public int getSlotLaneNo() {
		return slotLaneNo;
	}

	public void setSlotLaneNo(int slotLaneNo) {
		this.slotLaneNo = slotLaneNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
