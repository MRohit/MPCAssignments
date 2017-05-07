package com.psl.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 
 * @author YOGESH SHINDE
 * @since October 2014
 *
 */

public interface ConnectionManager 
{
	public Connection getDBConnection(String url, String user, String pwd) throws ClassNotFoundException, SQLException;
	public void closeConnection() throws SQLException;
}