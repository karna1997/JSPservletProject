package com.jbk.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	@SuppressWarnings("unused")
	private static Connection connection=null;
	public static Connection getConnectionMethod() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_demo", "root", "root");
		return  connection;
		
	}
	

}
