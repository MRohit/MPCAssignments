package com.psl.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.ArrayList;

import com.psl.beans.Customer;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class CustomerManagerDb 
{
	private static ArrayList<Customer> custList = new ArrayList<Customer>();
	
	/**
	 * 
	 * @param customers
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	
	public void insertCustomers(ArrayList<Customer> customers) throws SQLException, 
	ClassNotFoundException
	{	
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root"); 
		PreparedStatement pst = con.prepareStatement("insert into customer values(?, ?, ?, ?)");
		
		for(int i = 0; i < customers.size(); i++)
		{
			Customer c = customers.get(i);	custList.add(c);
			
			pst.setInt(1, c.getId());
			pst.setString(2, c.getName());
			pst.setString(3, c.getEmail());
			pst.setString(4, c.getAddress().toString());
			
			pst.executeUpdate();			
		}
		
		cm.closeConnection();
	}
	
	/**
	 * 
	 * @return ArrayList - Customer List
	 */
	
	public ArrayList<Customer> getCustomerList()
	{
		return custList;
	}
	
	/**
	 * 
	 * @param id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void deleteCustomer(int id) throws ClassNotFoundException, SQLException
	{
		ConnectionManager cm = new DBConnenctionManager();
		Connection con = cm.getDBConnection("jdbc:mysql:///OrderManagementDB", "root", "root");		
		PreparedStatement pst = con.prepareStatement("delete from customer where id = ?");
		pst.setInt(1, id);
		pst.executeUpdate();
	}
}