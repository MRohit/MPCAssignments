package com.bean;

import java.util.Date;

public class Wheat extends Item {
	private WheatType wheatType;

	public Wheat() {
	}
	public Wheat(int id, String description, float weight, float price,
			Date manufacturingDate, int useBeforeMonths, WheatType wheatType) {
		super(id, description, weight, price, manufacturingDate,
				useBeforeMonths);
		this.wheatType = wheatType;
	}
	public WheatType getWheatType() {
		return wheatType;
	}

	public void setWheatType(WheatType wheatType) {
		this.wheatType = wheatType;
	}
}
