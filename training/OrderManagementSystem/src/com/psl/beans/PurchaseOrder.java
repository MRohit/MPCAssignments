package com.psl.beans;

import java.io.Serializable;
import java.util.List;

import com.psl.exceptions.InvalidDateException;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class PurchaseOrder implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private static int oNo;
	private int orderNo;
	private Date orderDate, shipDate;
	private List<OrderItem> orderedItemsList;
	
	public PurchaseOrder(String orderDate, String shipDate,
			List<OrderItem> orderedItemsList) throws InvalidDateException 
	{
		oNo++;
		this.orderNo = oNo;
		this.orderDate = new Date(orderDate);
		this.shipDate = new Date(shipDate);
		this.orderedItemsList = orderedItemsList;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
		
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	
	public List<OrderItem> getOrderedItemsList() {
		return orderedItemsList;
	}
	public void setOrderedItemsList(List<OrderItem> orderedItemsList) {
		this.orderedItemsList = orderedItemsList;
	}
	
	@Override
	public String toString() 
	{
		String str = "\nOrder No: "+ orderNo + "\tOrder Date: " + orderDate + 
		"\tShip Date: " + shipDate;
		for(int i = 0; i < orderedItemsList.size(); i++)
			str += orderedItemsList.get(i);
		return str;
	}
}
