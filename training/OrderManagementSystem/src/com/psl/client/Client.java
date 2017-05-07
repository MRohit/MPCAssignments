package com.psl.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.psl.beans.Customer;
import com.psl.beans.Date;
import com.psl.beans.OrderItem;
import com.psl.beans.PurchaseOrder;
import com.psl.beans.StockItem;
import com.psl.dao.ConnectionManager;
import com.psl.dao.CustomerManagerDb;
import com.psl.dao.DBConnenctionManager;
import com.psl.dao.PurchaseOrderManagerDB;
import com.psl.dao.StockItemManagerDB;
import com.psl.exceptions.InsufficientDataException;
import com.psl.exceptions.InvalidDateException;
import com.psl.utility.PurchaseOrderManager;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 */

public class Client 
{
	static
	{		
		LogManager.getLogManager().addLogger(Logger.getLogger("OrderManagementSystem"));
	}
	
	private static Logger logger = null;
	
	/**
	 * Main Method to Initialised the System..
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		{
			logger = LogManager.getLogManager().getLogger("OrderManagementSystem");
			try 
			{
				logger.addHandler(new FileHandler("OMSLogs.log"));
			} 
			catch (SecurityException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		logger.info("Order Management System Started..!!!");
		
		PurchaseOrderManager pom = new PurchaseOrderManager();
		CustomerManagerDb cmdb = new CustomerManagerDb();
		StockItemManagerDB simdb = new StockItemManagerDB();
		PurchaseOrderManagerDB pomdb = new PurchaseOrderManagerDB();
		
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = null;
		
		try 
		{
			con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");
			Statement st = con.createStatement();
			
			st.executeUpdate("truncate table customer");
			st.executeUpdate("truncate table stockitem");
			st.executeUpdate("truncate table orderitem");
			st.executeUpdate("truncate table customerorder");
			st.executeUpdate("truncate table purchaseorder");
			st.executeUpdate("truncate table shippedorder");
			
			logger.info("Truncation of Tables Finished..!!!");
			
			//Populate customer and stock Items from file into database
			ArrayList<Customer> clist = pom.populateCustomers();
			cmdb.insertCustomers(clist);
			
			ArrayList<StockItem> slist = pom.populateStoreItems();
			simdb.insertStockItems(slist);
			
			//Display All Items to customer along with discounted Items
			System.out.println("\nAvailable Items: ");
			pom.showItems();
			
			System.out.println("\nDiscounted Items: ");
			pom.displayDiscountedItemsList();
			System.out.println();
			
			//Create Purchase Order for 3 customers
			ArrayList<OrderItem> oItems1 = new ArrayList<OrderItem>();
			OrderItem oi = null;
			
			oi = new OrderItem(111, 2);	pomdb.insertOrderItem(oi);	 
			oItems1.add(oi);
			oi = new OrderItem(444, 5);	pomdb.insertOrderItem(oi);
			oItems1.add(oi);
			oi = new OrderItem(555, 8);	pomdb.insertOrderItem(oi);
			oItems1.add(oi);				
			
			pom.createOrder(1, oItems1, null);
			
			ArrayList<OrderItem> oItems2 = new ArrayList<OrderItem>();
			
			oi = new OrderItem(222, 2);	pomdb.insertOrderItem(oi);
			oItems2.add(oi);
			oi = new OrderItem(666, 5);	pomdb.insertOrderItem(oi);
			oItems2.add(oi);
			oi = new OrderItem(333, 8);	pomdb.insertOrderItem(oi);
			oItems2.add(oi);
						
			pom.createOrder(3, oItems2, null);
			
			ArrayList<OrderItem> oItems3 = new ArrayList<OrderItem>();
			
			oi = new OrderItem(555, 2);	pomdb.insertOrderItem(oi);
			oItems3.add(oi);
			oi = new OrderItem(444, 5);	pomdb.insertOrderItem(oi);
			oItems3.add(oi);
			oi = new OrderItem(333, 8);	pomdb.insertOrderItem(oi);
			oItems3.add(oi);
			
			pom.createOrder(4, oItems3, "16/10/2014");
			
			System.out.println();
			
			//Generate Bill
			pom.shipOrders();
			logger.info("Orders Are Shipped..!!!");
			
			//Print all the Orders details along with customer id and Name			
			Map<Customer, ArrayList<PurchaseOrder>> map = pom.getOrdersByCustomer();
			ArrayList<PurchaseOrder> plist = null;
			Set<Customer> set = map.keySet();
			Iterator<Customer> it = set.iterator();
			while(it.hasNext())
			{
				Customer c = it.next();				
				System.out.println("\nCustomer Id: " + c.getId() + "\tCustomer Name: " + c.getName());
				System.out.println("\nOrders:- ");
				
				plist = map.get(c);
				if (plist != null)
				{
					for(int i = 0; i < plist.size(); i++)
						if(plist.get(i).getOrderedItemsList() != null)
							System.out.println(plist.get(i));
				}
				else
					System.out.println("\nItems Not Found..!!!");
			}
			
			//Store PurchaseOrder Objects into file
			pom.storePurchaseOrder();	
			logger.info("Purchase Order Object(s) Serialized..!!!");
			
			//Orders by Customer
			int custId = 1;
			System.out.println("\n\nOrders of Customer " + custId + ":");
			plist = pomdb.getAllOrdersByCustomer(custId);
			for(int i = 0; i < plist.size(); i++)
				System.out.println(plist.get(i));
			
			//Orders by Dates
			Date d1 = new Date("01-10-2014"), d2 = new Date("13-10-2014");
			System.out.println("\n\nOrders Shipped From " + d1 + " To " + d2 +":");
			plist = pomdb.ordersToBeShipped(d1, d2);
			for(int i = 0; i < plist.size(); i++)
				System.out.println(plist.get(i));
		}
		catch (SQLException e) 
		{
			logger.warning("SQL Exception Generated..!!!");
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			logger.warning("SQL Driver Exception..!!!");
			e.printStackTrace();
		}
		catch (NumberFormatException e) 
		{
			logger.warning("Date Validation Error..!!!");
			e.printStackTrace();
		}
		catch (FileNotFoundException e) 
		{
			logger.warning("File Not Found Exception Generated..!!!");
			e.printStackTrace();
		}
		catch (InvalidDateException e) 
		{
			logger.warning("Date Validation Error..!!!");
			e.printStackTrace();
		}		
		catch (ParseException e) 
		{
			logger.warning("Date Exception..!!!");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			logger.warning("IO Exception..!!!");
			e.printStackTrace();
		} 
		catch (InsufficientDataException e) 
		{
			logger.warning("Insufficent Data in Given Files..!!!");
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
				logger.fine("All is Well..!!!");
			} 
			catch (SQLException e) 
			{
				logger.warning("SQL Exception Generated..!!!");
				e.printStackTrace();
			}
		}
		
		logger.info("Good Bye..!!!");
	}
}
