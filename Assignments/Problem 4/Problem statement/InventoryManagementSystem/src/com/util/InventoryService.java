package com.util;

import java.util.List;

import com.bean.Item;
import com.exception.NoDataFoundException;

public interface InventoryService {
	// Read Data from database and store in an List<Item>.Read data from milk_tbl,cheese_tbl and wheat_tbl and store in the Inventory(List<Item>).
	List<Item> readAllItemsFromDb();
	
	// Calculate the Expiry date for the Item  
	void calculateExpiryDate(List<Item> items);
	
	//Remove the expired items from the Inventory(List<Item>) 
	void removeExpiredItems(List<Item> items);
	
	//Sort Items In Descending  order of Expiry Date. 
	void sortItems(List<Item> items);
	
	//Apply 20% discount on Items to be expired in next six months 
	void applyDiscount(List<Item> items);
	
	// Search Items in the Inventory  
	List<Item> searchItem(String ItemType,List<Item> list) throws NoDataFoundException;	

}
