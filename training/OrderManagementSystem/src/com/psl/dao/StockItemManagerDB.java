package com.psl.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.psl.beans.StockItem;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class StockItemManagerDB 
{
	private static ArrayList<StockItem> slist = new ArrayList<StockItem>();
	
	/**
	 * 
	 * @param stockItemlist
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void insertStockItems(ArrayList<StockItem> stockItemlist) throws 
	FileNotFoundException, ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");
		PreparedStatement pst = con.prepareStatement("insert into stockitem values (?, ?, ?, ?, ?, ?, ?)");
		
		for(int i = 0; i < stockItemlist.size(); i++)
		{
			StockItem si = stockItemlist.get(i);	slist.add(si);
			
			pst.setInt(1, si.getId());
			pst.setString(2, si.getName());
			pst.setString(3, si.getDescription());
			pst.setString(4, String.valueOf(si.getUnit()));
			pst.setFloat(5, si.getPricePerUnit());
			pst.setString(6, si.getMfgDate().toString());
			pst.setString(7, si.getBestBeforeDate().toString());
			
			pst.executeUpdate();
		}
		
		cm.closeConnection();
	}
	
	/**
	 * 
	 * @return ArrayList - Stock Items
	 */
	
	public ArrayList<StockItem> getStockItems()
	{
		return slist;
	}
	
	/**
	 * 
	 * @param no
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void deleteStockItems(int no) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("delete from stockitem where id = ?");
		pst.setInt(1, no);
		pst.executeUpdate();
	}
	
	/**
	 * 
	 * @param id
	 * @param pricePerUnit
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void updateRow(int id, float pricePerUnit) throws ClassNotFoundException, SQLException 
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("update stockitem set priceperunit = ? where id = ?");
		pst.setFloat(1, pricePerUnit);
		pst.setInt(2, id);
		pst.executeUpdate();
	}
}
