package com.psl.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.psl.beans.Address;
import com.psl.beans.Customer;
import com.psl.beans.Date;
import com.psl.beans.OrderItem;
import com.psl.beans.PurchaseOrder;
import com.psl.beans.StockItem;
import com.psl.beans.Units;

import com.psl.dao.CustomerManagerDb;
import com.psl.dao.PurchaseOrderManagerDB;
import com.psl.dao.StockItemManagerDB;

import com.psl.exceptions.InsufficientDataException;
import com.psl.exceptions.InvalidDateException;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 */

public class PurchaseOrderManager 
{
	/**
	 * 
	 * @return ArrayList - Customer List
	 * @throws FileNotFoundException
	 * @throws InsufficientDataException
	 */
	
	public ArrayList<Customer> populateCustomers() throws FileNotFoundException, 
	InsufficientDataException
	{
		ArrayList<Customer> custList = new ArrayList<Customer>();
		
		Scanner in = new Scanner(new File("customer.txt"));		
		
		while(in.hasNext())
		{
			String cust[] = in.nextLine().split(",");
			
			for(int i = 0; i < cust.length; i++) 
				if(cust[i] == null)
					throw new InsufficientDataException();
			
			Address addr = new Address(cust[3].trim(), cust[4].trim(), cust[5].trim(),
					Integer.parseInt(cust[6].trim()));
			Customer c = new Customer(Integer.parseInt(cust[0].trim()), cust[1].trim(),
					cust[2].trim(), addr);
			custList.add(c);
			addr = null;	c = null;
		}
		
		return custList;
	}
	
	/**
	 * 
	 * @return ArrayList - List of Available Items in Stock
	 * @throws NumberFormatException
	 * @throws InvalidDateException
	 * @throws FileNotFoundException
	 * @throws InsufficientDataException
	 */
	
	public ArrayList<StockItem> populateStoreItems () throws NumberFormatException, 
	InvalidDateException, FileNotFoundException, InsufficientDataException
	{
		ArrayList<StockItem> sItemList = new ArrayList<StockItem>();
		Scanner in  = new Scanner(new File("stockitems.txt"));
		
		while(in.hasNext())
		{
			String item[] = in.nextLine().split(",");
			
			for(int i = 0; i < item.length; i++) 
				if(item[i] == null)
					throw new InsufficientDataException();
			
			
			StockItem si = new StockItem(Integer.parseInt(item[0].trim()), item[1].
					trim(),	item[2].trim(), Units.valueOf(item[3].trim()), Float.
					parseFloat(item[4].trim()), item[5].trim(), item[6].trim());
			
			sItemList.add(si);
			
			si = null;
		}
		
		return sItemList;
	}
	
	/**
	 * 
	 * @param cust_id
	 * @param oItems
	 * @param ship_date
	 * @throws InvalidDateException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void createOrder(int cust_id, List<OrderItem> oItems, String ship_date) 
	throws InvalidDateException, ClassNotFoundException, SQLException
	{
		PurchaseOrderManagerDB pomdb = new PurchaseOrderManagerDB();
		
		CustomerManagerDb cmdb = new CustomerManagerDb();		
		ArrayList<Customer> custList = cmdb.getCustomerList();
			
		Calendar cal = Calendar.getInstance(); cal.setTime(new java.util.Date());
		
		String curDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH)+1) + 
		"/"	+ cal.get(Calendar.YEAR);
		
		if (ship_date == null)
			ship_date = (cal.get(Calendar.DATE) + 6) + "/" + (cal.get(Calendar.MONTH)+1)
			+ "/" + cal.get(Calendar.YEAR);
		
		PurchaseOrder po = new PurchaseOrder(curDate, ship_date, oItems);
		
		if (pomdb.insertCustomerOrder(cust_id, po.getOrderNo()) && pomdb.insertPurchaseOrder(po))
			System.out.println("Order " + po.getOrderNo() + " is Created..!!!");
		
		for(int i = 0; i < custList.size(); i++)
		{
			if(custList.get(i).getId() == cust_id)
			{
				List<PurchaseOrder> list = custList.get(i).getPurchaseOrderList();
				if(list == null)
					list = new ArrayList<PurchaseOrder>();				
				list.add(po);
				custList.get(i).setPurchaseOrderList(list);
			}
		}
	}
	
	/**
	 * Purchase Order Objects Serialization
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public void storePurchaseOrder() throws FileNotFoundException, IOException
	{
		CustomerManagerDb cmdb = new CustomerManagerDb();		
		ArrayList<Customer> custList = cmdb.getCustomerList();
		
		for(int i = 0; i < custList.size(); i++)
		{
			List<PurchaseOrder> plist = custList.get(i).getPurchaseOrderList();
			if(plist != null)
			{
				for(int j = 0; j < plist.size(); j++)
				{
					PurchaseOrder po = plist.get(j);
					String fn = "PoNo_" + po.getOrderNo() + ".ser";
					File file = new File("Purchase_Order/" + fn);
					file.getParentFile().mkdirs();
					ObjectOutputStream ois = new ObjectOutputStream(new 
							FileOutputStream(file));
					ois.writeObject(po);
				}
			}
		}
	}
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	
	public void shipOrders() throws ClassNotFoundException, SQLException, IOException
	{
		PurchaseOrderManagerDB pomdb = new PurchaseOrderManagerDB();
		
		CustomerManagerDb cmdb = new CustomerManagerDb();		
		ArrayList<Customer> custList = cmdb.getCustomerList();
		
		for(int i = 0; i < custList.size(); i++)
		{
			int custId = custList.get(i).getId();
			
			ArrayList<PurchaseOrder> plist = (ArrayList<PurchaseOrder>) custList.get(i).getPurchaseOrderList();
			
			if(plist != null)
				pomdb.insertShippedOrders(custId, plist, null, "Person ");
		}
	}
	
	/**
	 * 
	 * @throws InvalidDateException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ParseException
	 */
	
	void removeExpiredItems() throws InvalidDateException, ClassNotFoundException, 
	SQLException, ParseException
	{
		StockItemManagerDB sidb = new StockItemManagerDB();
		ArrayList<StockItem> sItemList = sidb.getStockItems();
		
		Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance();	
		c2.setTime(new java.util.Date());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		for(int i = 0; i < sItemList.size(); i++)
		{
			c1.setTime(sdf.parse(sItemList.get(i).getBestBeforeDate().toString()));
			if(c1.before(c2))
			{
				sidb.deleteStockItems(sItemList.get(i).getId());
				sItemList.remove(i);
			}
		}
	}
	
	/**
	 * Stock Items without Expired Items 
	 * @throws InvalidDateException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ParseException
	 */
	
	public void showItems() throws InvalidDateException, ClassNotFoundException, 
	SQLException, ParseException
	{
		removeExpiredItems(); // removing expired items
		
		ArrayList<StockItem> slist = (new StockItemManagerDB()).getStockItems();	
		
		Collections.sort(slist, new ItemsByBestBeforeDate());
		
		for(int i=0; i<slist.size(); i++)
			System.out.println(slist.get(i));		
	}
	
	/**
	 * 
	 * @throws InvalidDateException
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void applyDiscountOnItems () throws InvalidDateException, ParseException, ClassNotFoundException, SQLException
	{
		Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance();
		
		StockItemManagerDB sidb = new StockItemManagerDB();
		ArrayList<StockItem> slist = sidb.getStockItems();	
		
		for(int i = 0; i < slist.size(); i++)
		{
			StockItem si = slist.get(i);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			
			c1.setTime(sdf.parse(si.getBestBeforeDate().toString()));
			
			c2.setTime(new java.util.Date());	c2.add(Calendar.MONTH, 2);
			
			if(c1.before(c2) || c1.equals(c2))
			{
				si.setPricePerUnit((float) (si.getPricePerUnit() * 0.40));
				sidb.updateRow(si.getId(), si.getPricePerUnit());
				System.out.println(si);
			}
		}
	}
	
	/**
	 * 
	 * @return Map - Customer with Given Purchase Order(s)
	 */
	
	public Map<Customer, ArrayList<PurchaseOrder>> getOrdersByCustomer()
	{
		Map<Customer, ArrayList<PurchaseOrder>> map = new HashMap<Customer, 
		ArrayList<PurchaseOrder>>();
		
		CustomerManagerDb cmdb = new CustomerManagerDb();		
		ArrayList<Customer> custList = cmdb.getCustomerList();
		
		for(int i = 0; i < custList.size(); i++)
		{
			Customer c = custList.get(i);
			map.put(c, (ArrayList<PurchaseOrder>) c.getPurchaseOrderList());
		}
		
		return map;
	}
	
	/**
	 * Displaying Discounted Items
	 * @throws InvalidDateException
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void displayDiscountedItemsList() throws InvalidDateException, ParseException, ClassNotFoundException, SQLException
	{
		applyDiscountOnItems();
	}
}

/**
 * 
 * @author YOGESH SHINDE
 *
 */

class ItemsByBestBeforeDate implements Comparator<StockItem> 
{
	@Override	
	public int compare(StockItem si1, StockItem si2) 
	{
		Date d1 = si1.getBestBeforeDate(), d2 = si2.getBestBeforeDate();
		if(d1.getY() == d2.getY() && d1.getM() == d2.getM() && d1.getD() == d1.getD())
			return 0;
		else if(d1.getY() < d2.getY() && d1.getM() < d2.getM() && d1.getD() < d1.getD())
			return -1;
		return 1;
	}
}

