package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Override and implement all the methods of DBConnectionUtil here to create and close db connection 
public class DatabaseConnectionManager implements DBConnectionUtil {

	Connection con=null;
	@Override
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {


		String url="jdbc:mysql://localhost:3306/questiondb";
		String Driver="com.mysql.jdbc.Driver";
		String username="root";
		String password="grapes";
		
		//1.Load Driver
		Class.forName(Driver);
		//2.Establish Connection
		con=DriverManager.getConnection(url,username,password);
		
		
		return con;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		con.close();
	}


}
