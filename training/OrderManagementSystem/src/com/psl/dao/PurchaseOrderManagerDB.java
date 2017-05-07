package com.psl.dao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;

import com.psl.beans.Customer;
import com.psl.beans.Date;
import com.psl.beans.OrderItem;
import com.psl.beans.PurchaseOrder;
import com.psl.beans.StockItem;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class PurchaseOrderManagerDB 
{
	/**
	 * 
	 * @param o
	 * @return boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public boolean insertOrderItem(OrderItem o) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("insert into orderitem values(?, ?, ?)");
		pst.setInt(1, o.getOrderNo());
		pst.setInt(2, o.getStockItemId());
		pst.setInt(3, o.getQty());
		if(pst.executeUpdate() > 0)
			return true;
		return false;	
	}
	
	/**
	 * 
	 * @param p
	 * @return boolean
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	
	public boolean insertPurchaseOrder(PurchaseOrder p) throws SQLException, ClassNotFoundException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("insert into purchaseorder values(?, ?, ?)");
		pst.setInt(1, p.getOrderNo());
		pst.setString(2, p.getOrderDate().toString());
		pst.setString(3, p.getShipDate().toString());
		if(pst.executeUpdate() > 0)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param custNo
	 * @param orderNo
	 * @return boolean
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public boolean insertCustomerOrder(int custNo, int orderNo) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("insert into customerorder values(?, ?)");
		pst.setInt(1, custNo);
		pst.setInt(2, orderNo);
		if(pst.executeUpdate() > 0)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param cust_id
	 * @return ArrayList - Purchase Order List of Given Customer
	 */
	
	public ArrayList<PurchaseOrder> getAllOrdersByCustomer(int cust_id)
	{
		ArrayList<Customer> clist = new CustomerManagerDb().getCustomerList();
		
		ArrayList<PurchaseOrder> plist = null;
		
		for(int i=0; i<clist.size(); i++)
			if(clist.get(i).getId() == cust_id)
			  plist = (ArrayList<PurchaseOrder>) clist.get(i).getPurchaseOrderList();
		
		return plist;
	}
	
	/**
	 * 
	 * @param fromdate
	 * @param todate
	 * @return ArrayList  
	 * @throws ParseException
	 */
	
	public ArrayList<PurchaseOrder> ordersToBeShipped(Date fromdate, Date todate) throws ParseException
	{
		Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance(), 
		c3 = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");		
		c1.setTime(sdf.parse(fromdate.toString()));
		c2.setTime(sdf.parse(todate.toString()));
				
		ArrayList<Customer> clist = new CustomerManagerDb().getCustomerList();
		
		ArrayList<PurchaseOrder> plist = new ArrayList<PurchaseOrder>();
		
		for(int i = 0; i < clist.size(); i++)
		{
			ArrayList<PurchaseOrder> list = (ArrayList<PurchaseOrder>) clist.get(i).getPurchaseOrderList();
			if(list != null)
			{
			  for(int j = 0; j < list.size(); j++)
			  {
				c3.setTime(sdf.parse(list.get(j).getShipDate().toString()));
				if((c3.after(c1) && c3.before(c2)) || c3.equals(c1) || c3.equals(c2))
					plist.add(list.get(j));
			  }
			}
		}
		
		return plist;
	}
	
	/**
	 * 
	 * @param orderno
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void deletePurchaseOrder(int orderno) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("delete from purchaseorder where orderno = ?");
		pst.setInt(1, orderno);
		pst.executeUpdate();
	}
	
	/**
	 * 
	 * @param orderno
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void deleteOrderItem(int orderno) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("delete from orderitem where orderno = ?");
		pst.setInt(1, orderno);
		pst.executeUpdate();
	}
	
	/**
	 * 
	 * @param custId
	 * @param plist
	 * @param olist
	 * @param PersonName
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	
	public void insertShippedOrders(int custId, ArrayList<PurchaseOrder> plist, 
	ArrayList<OrderItem> olist, String PersonName) throws ClassNotFoundException, 
	SQLException, IOException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");
		PreparedStatement pst = con.prepareStatement("insert into shippedorder values (?, ?, ?, ?, ?, ?, ?)");
		
		int pno = 0, qty, k;
		PrintWriter pw = null;
		String custName = null, itemName = null, odate, sdate;
		float grandTotal = 0.0f, totalPrice = 0.0f, price = 0.0f;		
		
		for(int i = 0; i < plist.size(); i++)
		{
			pst.setInt(1, custId);
			
			PurchaseOrder po = plist.get(i);		
			pno = po.getOrderNo();
			odate = po.getOrderDate().toString();
			sdate = po.getShipDate().toString();			
			
			pst.setInt(2, pno);
			pst.setString(3, odate);
			pst.setString(4, sdate);
			
			ArrayList<Customer> clist = new CustomerManagerDb().getCustomerList();
			for(k = 0; k < clist.size(); k++)
				if(clist.get(k).getId() == custId)
					custName = clist.get(k).getName();
			
			
			File file = new File("CustomerBills\\" + sdate + "\\" + custId + "\\"
			+ custName + "_" + sdate + "_" + pno + ".txt");
			file.getParentFile().mkdirs();					
			pw = new PrintWriter(file);					  
			pw.println("Customer ID: " + custId);	
			pw.println("\nCustomer Name: " + custName);
			pw.println("\nOrder Date: " + odate + "\tShip Date: " + sdate);
			pw.println("\nOrder Item\tQty\tPrice\tTotal Price");
					
					
			olist = (ArrayList<OrderItem>) po.getOrderedItemsList();
			for(int j = 0; j < olist.size(); j++)
			{
				OrderItem oi = olist.get(j);
				
				qty = oi.getQty();			
				
				pst.setInt(5, oi.getStockItemId());
				pst.setInt(6, qty);
				pst.setString(7, PersonName + pno);
				
				pst.executeUpdate();
				
				// Bill Creation
				
				ArrayList<StockItem> slist = new StockItemManagerDB().getStockItems();
				
				for(k = 0; k < slist.size(); k++)
				{
					if(slist.get(k).getId() == oi.getStockItemId())
					{
						itemName = slist.get(k).getName();
						price = slist.get(k).getPricePerUnit();
					}
				}
				
				totalPrice = qty * price;				
				
				pw.println(itemName + "\t\t" + qty + "\t" + price + "\t" + totalPrice);
							 
				grandTotal += totalPrice;
				
				deleteOrderItem(oi.getOrderNo()); // deleting from database
			}
			
			System.out.println("Order " + pno +" is Shipped..!!!");
			
			if (pw != null)
			{
				pw.println();	pw.println();
				pw.println("Grand Total: " + grandTotal);
				System.out.println("Bill is Generated for Purchase Order " + pno + "..!!!\n");
				pw.close();
			}
			
			deletePurchaseOrder(pno); // deleting from database
		}
	}
}