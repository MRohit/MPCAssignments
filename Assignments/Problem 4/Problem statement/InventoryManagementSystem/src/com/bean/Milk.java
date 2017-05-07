package com.bean;

import java.util.Date;

public class Milk extends Item {
	private float fatRate;
    private MilkType milkpacket;
    
    public Milk(){
    	super();
    }
    public Milk(int id, String description, MilkType milkpacket,float weight, float price,
			Date manufacturingDate,int useBeforeMonths,float fatRate) {
		super(id, description, weight, price, manufacturingDate, useBeforeMonths);
		this.fatRate = fatRate;
		this.milkpacket=milkpacket;

	}
    public float getFatRate() {
		return fatRate;
	}

	public void setFatRate(float fatRate) {
		this.fatRate = fatRate;
	}
	

	public MilkType getMilkpacket() {
		return milkpacket;
	}

	public void setMilkpacket(MilkType milkpacket) {
		this.milkpacket = milkpacket;
	}
	
}


