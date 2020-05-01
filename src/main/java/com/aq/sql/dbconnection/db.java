package com.aq.sql.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL;
	static final String USER = "";
	static final String PASS = "";

	Connection conn = null;
	Statement stmt = null;
	
	public db(String database) {
		DB_URL = "jdbc:mysql://localhost:3306/"+database+"?useSSL=false";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(
		ClassNotFoundException e11)
		{
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}System.out.println("Starting DB Connection..");

		try
		{
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(
		SQLException e111)
		{
			// TODO Auto-generated catch block
			e111.printStackTrace();
		}
		System.out.println("DB Connected");
		
		System.out.println("Starting insert statements");
		try
		{
			stmt = conn.createStatement();
		}catch(
		SQLException e11111)
		{
			// TODO Auto-generated catch block
			e11111.printStackTrace();
			
		}
	}
	///
//	public String testSQLException() {
//		try
//		{
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//		}catch(
//		SQLException e111)
//		{
//			// TODO Auto-generated catch block
//			e111.printStackTrace();
//		}
//		return DB_URL;
//	}
	
	
	public String/*void*/ createCustomer(String name, String address, String email, String password) {
		String query = "INSERT INTO gamecustomers VALUES(0,'"+name+"','"+address+"','"+password+"','"+email+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
		
	}
	
	public String/*void*/ updateCustomer(String name, String address, String email, String password) {
		String query = "UPDATE gamecustomers SET customerName='ash123' WHERE customerName= 'ash'";
		return name;
	}
	
	public /*void*/ String selectCustomer(String name, String address, String email, String password) {
		String query = "SELECT * FROM gamecustomers WHERE customerID= 26";

		return name;
	}
	
	public /*void*/ String deleteCustomer(String name, String address, String email, String password) {
		//String query = "DELETE FROM gamecustomers WHERE customerName='ash123' WHERE customerName= 'ash'";
		String query = "DELETE FROM gamecustomers WHERE customerName= 'AshleyB'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public void createGame(String name, String age, String rating) {
		String query = "INSERT INTO gametable VALUES(0,'"+name+"','"+age+"','"+rating+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateGame(String name, String address, String email, String password) {
		String query = "UPDATE gametable SET game_name='ash123' WHERE game_name= 'ash'";
	}
	
	public void deleteGame(String name, String address, String email, String password) {
		String query = "DELETE FROM gametable WHERE game_name='ash123' WHERE game_name= 'ash'";
	}
	
	
	public void createOrder(String name, String dateOrdered, String price) {
		String query = "INSERT INTO gameorders VALUES(0,'"+name+"','"+dateOrdered+"','"+price+"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateOrder(String name, String dateOrdered, String price) {
		String query = "UPDATE gameorders SET totalamount='10.00' WHERE customerID= 5";
	}
	
	public void deleteOrder(String name, String dateOrdered, String price) {
		String query = "DELETE FROM gameorders WHERE totalamount='10.00' WHERE customerID= 5";
		System.out.println("Order has been deleted from...");
	}
	

}
