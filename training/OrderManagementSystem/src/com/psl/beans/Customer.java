package com.psl.beans;

import java.util.List;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class Customer 
{
	private int id;
	private String name, email;
	private List<PurchaseOrder> purchaseOrderList;
	private Address address;
	
	public Customer(int id, String name, String email, Address address) 
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.purchaseOrderList = null;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<PurchaseOrder> getPurchaseOrderList() {
		return purchaseOrderList;
	}
	public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList)	{
		this.purchaseOrderList = purchaseOrderList;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() 
	{
		String str = "\nCust_ID: " + id + "\nName: " + name + "\nEmail_ID: " + email 
		+ "\nAddress: " + address;		
		for(int i=0; i<purchaseOrderList.size(); i++)
			str += purchaseOrderList.get(i);
		return str;
	}
}
