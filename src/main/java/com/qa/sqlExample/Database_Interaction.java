
package com.qa.sqlExample;

import java.sql.*;

public class Database_Interaction extends GetInputFromUser{
	
	String mainUser = "user";

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "";
	static final String PASS = "";

	//public static void main(String[] args) {
		
		/// Inheritence example requires extends on the public class name
		//System.out.println("Enter your credentials:");
		GetInputFromUser obj = new GetInputFromUser();
		
		Option obj1 = new Option();

		public static String getDbUrl() {
			return DB_URL;
		}
		
		public static String getDbDriver() {
			return JDBC_DRIVER;
		}
		
		public static String getDbUser() {
			return USER;
		}
		
		public static String getDbPas() {
			return USER;
		}
}