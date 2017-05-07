package com.psl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public class DBConnenctionManager implements ConnectionManager 
{
	Connection con;
	
	@Override
	public void closeConnection() throws SQLException 
	{
        if(con != null)
        	con.close();
	}

	@Override
	public Connection getDBConnection(String url, String user, String pwd) 
	throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
}
