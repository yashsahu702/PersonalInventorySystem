package com.personalinventorysystem.utility;
import java.sql.*;


public class ConnectionPool {
	public static void main(String args[]) {
	
		ConnectionPool.connectDB;
	}
	static Connection conn = null;
	public static Connection connectDB() {
    System.out.println("Hii Java");
    
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/personalinventorysystem","root","2424");

	System.out.println("Database Connection success");

	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	
	

	
	return conn;
	}
public static void main(String args[]) {
		
		ConnectionPool.connectDB();
		}
	



}