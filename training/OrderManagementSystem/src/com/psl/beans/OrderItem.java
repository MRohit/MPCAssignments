package com.psl.beans;

import java.io.Serializable;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class OrderItem implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private static int oNo;
	private int orderNo, qty, stockItemId;
	
	public OrderItem(int stockItemId, int qty) 
	{
		oNo++;
		orderNo = oNo;
		this.qty = qty;
		this.stockItemId = stockItemId;
	}
	
	public int getOrderNo() 
	{
		return orderNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getStockItemId() {
		return stockItemId;
	}

	public void setStockItemName(int stockItemId) {
		this.stockItemId = stockItemId;
	}

	@Override
	public String toString() 
	{
		return "\nItem ID: " + stockItemId + "\tQuantity: " + qty;
	}
}
