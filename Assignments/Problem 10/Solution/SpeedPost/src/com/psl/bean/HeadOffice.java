package com.psl.bean;

import java.util.List;

public class HeadOffice {

	private String headOfficeId;
	private String city;
	private List<String> listOfPinCodes;
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof HeadOffice){
			HeadOffice office=(HeadOffice)obj;
			if(office.getHeadOfficeId().equals(this.getHeadOfficeId())){
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.headOfficeId.hashCode();
	}

	@Override
	public String toString() {
		return "HeadOffice [headOfficeId=" + headOfficeId + ", city=" + city
				+ ", listOfPinCodes=" + listOfPinCodes + "]";
	}

	public HeadOffice(String headOfficeId, String city,
			List<String> listOfPinCodes) {
		super();
		this.headOfficeId = headOfficeId;
		this.city = city;
		this.listOfPinCodes = listOfPinCodes;
	}

	public String getHeadOfficeId() {
		return headOfficeId;
	}

	public void setHeadOfficeId(String headOfficeId) {
		this.headOfficeId = headOfficeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getListOfPinCodes() {
		return listOfPinCodes;
	}

	public void setListOfPinCodes(List<String> listOfPinCodes) {
		this.listOfPinCodes = listOfPinCodes;
	}

}
