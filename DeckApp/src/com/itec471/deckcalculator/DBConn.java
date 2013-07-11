package com.itec471.deckcalculator;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;

public class DBConn {
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	
	/*
     *Connection to database.
     *
     */
	public static Connection getConnection() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
		driver = "mysql-connector-java.5.1.25-bin.jar";  //props.getProperty("jdbc.driver");
		url = "jdbc:mysql://212.1.215.209:3306/deckinat_2?zeroDateTimeBehavior=convertToNull";  //props.getProperty("jdbc.url");
		username = "deckinat_app";  //props.getProperty("jdbc.username");
		password = "app123";  //props.getProperty("jdbc.password");
		
		Class.forName(driver);
		
		return DriverManager.getConnection(url, username, password);
	}
	
	/*
     * getResults takes a sql string and returns a resultset.
     */
    public static ResultSet getResultValues(String sql) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        Connection Val = DBConn.getConnection();
        Statement getVal = Val.createStatement();
        ResultSet rs = getVal.executeQuery(sql);
        return rs;
    }
    /*
     * save takes in the information required to save project data and inserts it as a new record.
     */
    public static void save(String email, String planname, Double height, Double length, Double width, Double sqfootage) {       
        try {
            Connection conn = DBConn.getConnection();
         String sql = "INSERT INTO usersave (`email`, `planname`, `height`, `length`, `width`, `sqfootage`)"
                 + "VALUES(?, ?, ?, ?, ?, ?);";
            PreparedStatement prest;
            prest = conn.prepareStatement(sql);
            prest.setString(1, email);
            prest.setString(2, planname);
            prest.setDouble(3, height);
            prest.setDouble(4, length);
            prest.setDouble(5, width);
            prest.setDouble(6, sqfootage);
            prest.execute();
        } catch ( SQLException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
        	Logger.getLogger(DBConn.class.getName ()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
