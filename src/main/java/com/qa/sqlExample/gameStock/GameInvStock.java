package com.qa.sqlExample.gameStock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.aq.sql.dbconnection.db;
import com.qa.sqlExample.Database_Interaction;
import com.qa.sqlExample.GetInputFromUser;
import com.qa.sqlExample.Option;
import com.qa.utilities.Utilities;

public class GameInvStock {

	public void Game_Inventory() {
		// public static void main(String[] args) {
		GetInputFromUser fistName = new GetInputFromUser();
		GetInputFromUser surname = new GetInputFromUser();
		GetInputFromUser _age = new GetInputFromUser();//
		GetInputFromUser email = new GetInputFromUser();
		GetInputFromUser phoneNo = new GetInputFromUser();
		GetInputFromUser passwd = new GetInputFromUser();//
		GetInputFromUser pCode = new GetInputFromUser();
		GetInputFromUser address = new GetInputFromUser();

//			Database_Interaction dbb = new Database_Interaction();
//			
//			Database_Interaction.dbb();

		String JDBCDRV = Database_Interaction.getDbDriver();
		String DB_URL = Database_Interaction.getDbUrl();
		String USER = Database_Interaction.getDbUser();
		String PASS = Database_Interaction.getDbPas();

		/// placeholder remove these after testing

		String tableName = "gametable";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBCDRV);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Starting connection to db");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("connected!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Scanner in = new Scanner(System.in);
		int option = 1;
		while (true)

		{

			if (option == 4) {
				System.exit(0);

//					Option option__ = new Option();
//					
//					
//					option__.Option1();
			}

			switch (option) {

			case 1:
				System.out.println("you Selected Inventory Stock");

				while (true) {
					System.out.println("Choose which data to insert\n");
					System.out.println(
							"(1): Option 1 - insert inventory info\n(2): Option 2 - Obtain inventory info\n(3): Option 3 - delete inventory info\n(4): Exit\n(5): Modify Customer Info\\n");
					option = in.nextInt();

					switch (option) {

					case 1:

						while (true) {

							System.out.println("Enter Game Name\n");
							String firstn_str = Utilities.getUserInput();
							System.out.println("GameName: " + firstn_str);

							System.out.println("Enter Age Rating\n");

							Scanner ageofper = new Scanner(System.in);

							int age_;
							do {
								// System.out.print("Please enter a positive number: ");
								while (!ageofper.hasNextInt()) {
									String input = ageofper.next();
									System.out.printf("\"%s\" is not a valid number.\n", input);
								}
								age_ = ageofper.nextInt();
							} while (age_ < 0);

							System.out.println("Age: " + age_);

							System.out.println("Enter Platform(s)\n");

							String addres_Str = Utilities.getUserInput();

							System.out.println("Platform(s): " + addres_Str);

							System.out.println("Postcode (Include a space)\n");

							System.out.println("Physical Release?\n");

							String postcode_Str = Utilities.getUserInput();

							System.out.println("Physical Release?: " + postcode_Str);

							String price = Utilities.getUserInput();
							
							String price_str = Utilities.getUserInput();

							System.out.println("Price?: " + price_str);

							int age = age_;

							System.out.println("Starting insert statement");
							try {
								stmt = conn.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							String sqlInsert = "INSERT INTO " + tableName + " VALUES(0,'" + firstn_str + "', '"
									+ age + "','" + addres_Str + "','" + postcode_Str + "', " + price + ")";
							try {
								stmt.executeUpdate(sqlInsert);
								conn.close();
								System.out.println("Record inserted!");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							if (option == 5) {
								System.exit(0);
							}

							switch (option) {
							//
							case 1:

								break;
							case 2:
								System.out.println("Case 2");

								break;
							case 3:

								break;
							case 4:

							default:
								System.out.print("Please enter a valid option 1, 2 or 3");

								break;
							}// end of switch

						} // end of while loop

					case 2:
						while (true) {
							// WHEN OPTION 1 IS FIRST SELECTED THEN OPTION 2 IS SELECTED EG THIS COULD BE
							// FOR ONLY MODIFIYING CUST INFO
							System.out.println("Obtain / Select Customer Info.\n");

							System.out.println("Enter Customer info\n");
							if (option == 4) {
								System.exit(0);
							}

							System.out.println("Enter PostCode of Customer\n");

							String postalCode = Utilities.getUserInput();

							String postCode = postalCode;

							System.out.println("Creating select statement");
							try {
								stmt = conn.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							String sql2 = "SELECT customerID,customerName,email,address,postCode from " + tableName
									+ " WHERE postCode = '" + postCode + "';";
							ResultSet rs = null;
							try {
								rs = stmt.executeQuery(sql2);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								while (rs.next()) {
									int id1 = rs.getInt("customerID");
									String name1 = rs.getString("customerName");
									String email1 = rs.getString("email");
									String postcodee = rs.getString("postCode");
									System.out.println(" ID: " + id1 + " Name: " + name1 + " Email: " + email1
											+ " PostCode: " + postcodee);
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							switch (option) {

							case 1:

								break;
							case 2:

								break;
							case 3:

								break;
							default:
								System.out.print("Please enter a valid option 1, 2 or 3");
								break;
							}// end of switch

						} // end of while loop

					case 3:
						while (true) {

							System.out.println("Modify / Delete Customer Info.\n");
							System.out.println("Enter Customer info\n");
							if (option == 4) {
								System.exit(0);
							}

							System.out.println("Enter id of Customer\n");

							Scanner idofcust = new Scanner(System.in);

							int idval;
							do {

								while (!idofcust.hasNextInt()) {
									String input = idofcust.next();
									System.out.printf("\"%s\" is not a valid id.\n", input);
								}
								idval = idofcust.nextInt();
							} while (idval < 0);
							System.out.println("Creating delete statement"); // '" + name + "' name is currently causing
																				// invalid sql syntax
							try {
								stmt = conn.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							String sql2 = "DELETE FROM gameorders WHERE customerID= " + idval + ";";
							try {

								stmt.executeUpdate(sql2);
								System.out.println(
										"Record has now been deleted from the " + tableName + "at ID: " + idval);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							switch (option) {

							case 1:

								break;
							case 2:

								break;
							case 3:

								break;
							default:
								System.out.print("Please enter a valid option 1, 2 or 3");
								break;
							}// end of switch

						} // end of while loop

					default:
						System.out.print("Please enter a valid option 1, 2 or 3");
						break;
					}// end of switch

				}
			}
		}
	}

	public static void main(Object object) {
		// TODO Auto-generated method stub

	}
}
