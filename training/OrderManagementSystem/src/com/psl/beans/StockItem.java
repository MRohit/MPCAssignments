package com.psl.beans;

import com.psl.exceptions.InvalidDateException;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class StockItem 
{
	private int id;
	private String name, description;;
	private Units unit;
	private float pricePerUnit;
	private Date mfgDate, bestBeforeDate;
	
	public StockItem(int id, String name, String description, Units unit,
	float pricePerUnit, String mfgDate, String bestBeforeDate) throws InvalidDateException 
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.unit = unit;
		this.pricePerUnit = pricePerUnit;
		this.mfgDate = new Date(mfgDate);
		this.bestBeforeDate = new Date(bestBeforeDate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Units getUnit() {
		return unit;
	}

	public void setUnit(Units unit) {
		this.unit = unit;
	}

	public float getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getBestBeforeDate() {
		return bestBeforeDate;
	}

	public void setBestBeforeDate(Date bestBeforeDate) {
		this.bestBeforeDate = bestBeforeDate;
	}

	@Override
	public String toString() 
	{
		return id + ", " + name + ", " + description + ", " + unit + ", " + 
		pricePerUnit + ", " + mfgDate + ", " + bestBeforeDate;
	}
}
