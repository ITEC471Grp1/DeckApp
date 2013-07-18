package com.itec471.deckcalculator;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;

public class DBConn {
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	
	public void PostConn() throws FileNotFoundException, IOException, ClassNotFoundException{		
	}
	
	public static Connection getConnection() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
		driver = "com.mysql.jdbc.Driver";  //props.getProperty("jdbc.driver");
		url = "jdbc:mysql://mysql112.00webhost.com/";  //props.getProperty("jdbc.url");
		username = "a9830450_group2";  //props.getProperty("jdbc.username");
		password = "radgroup2";  //props.getProperty("jdbc.password");
		
		Class.forName(driver);
		
		return DriverManager.getConnection(url, username, password);
	}

}
