package com.psl.beans;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class Address 
{
	private int zip;
	private String street, city, state;
	
	public Address(String street, String city, String state, int zip) 
	{
		this.zip = zip;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() 
	{
		return street + "," + city + "," + state + "," + zip;
	}
}
