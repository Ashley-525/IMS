package com.qa.sqlExample.orderSwitch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.qa.sqlExample.GetInputFromUser;
import com.qa.sqlExample.Database_Interaction;
import com.qa.utilities.Utilities;

public class OrderSwitchCase {
	public void OrderSwitchCase_() {
	//public static void main(String[] args) {
		GetInputFromUser fistName = new GetInputFromUser();
		GetInputFromUser surname = new GetInputFromUser();
		GetInputFromUser _age = new GetInputFromUser();//
		GetInputFromUser email = new GetInputFromUser();
		GetInputFromUser phoneNo = new GetInputFromUser();
		GetInputFromUser passwd = new GetInputFromUser();//
		GetInputFromUser pCode = new GetInputFromUser();
		GetInputFromUser address = new GetInputFromUser();

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
		final String USER = "";
		final String PASS = "";

		/// placeholder remove these after testing

		String tableName = "gameorders";
		Connection conn = null;
		Statement stmt = null;
		Scanner in = new Scanner(System.in);
		int option = 1;
		while (true)

		{

			// System.out.println("Choose which Data you'd like to modify for orders\n");
			System.out.println(
					"(1): Option 1 - Add Order\n(2): Option 2 - Modify Orders\n(3): Option 3 - Delete Order\n(4): Exit");
			System.out.println("Enter a Choice: ");
			option = in.nextInt();

			if (option == 4) {
				System.exit(0);
			}

			switch (option) {

			case 1:
				System.out.println("you Selected Order Data");

				while (true) {
					System.out.println("Choose which data to insert\n");
					System.out.println(
							"(1): Option 1 - insert order info\n(2): Option 2 - Obtain order info\n(3): Option 3 - delete order info\n(4): Exit\n(5): Modify Customer Info\\n");
					option = in.nextInt();

					switch (option) {

					case 1:

						while (true) {

							System.out.println("Enter Game ID\n");
							// String firstn_str = Utilities.getUserInput();
							Scanner gameid = new Scanner(System.in);
							int game_id;
							do {
								// System.out.print("Please enter a positive number: ");
								while (!gameid.hasNextInt()) {
									String input = gameid.next();
									System.out.printf("\"%s\" is not a valid number.\n", input);
								}
								game_id = gameid.nextInt();
							} while (game_id < 0);
							System.out.println("GameID: " + game_id);

							System.out.println("Enter Customer ID\n");
							// String firstn_str = Utilities.getUserInput();
							Scanner customerIdee = new Scanner(System.in);
							int cusID;
							do {
								// System.out.print("Please enter a positive number: ");
								while (!customerIdee.hasNextInt()) {
									String input = customerIdee.next();
									System.out.printf("\"%s\" is not a valid number.\n", input);
								}
								cusID = customerIdee.nextInt();
							} while (cusID < 0);

							// System.out.printf("You have entered a positive number %d.\n", age_);

							System.out.println("CustomerID: " + cusID);

							System.out.println("Enter Date Order was Placed on YYYY-MM-DD\n");

							String lastName_str = Utilities.getUserInput();

							// surname.setSurname(lastName_str);

							System.out.println("DAte Ordered: " + lastName_str);

							System.out.println("Enter Total Amount\n");
							// System.out.println("(1): Option 1 -something\n(2): Option 2 - something
							// else\n(3): Option 3 - something else\n(4): Option 4 - Previous Menu\n(5):
							// Exit\n");
							Scanner ageofper = new Scanner(System.in);

							// int age_ = ageofper.nextInt();

							int age_;
							do {
								// System.out.print("Please enter a positive number: ");
								while (!ageofper.hasNextInt()) {
									String input = ageofper.next();
									System.out.printf("\"%s\" is not a valid number.\n", input);
								}
								age_ = ageofper.nextInt();
							} while (age_ < 0);

							// System.out.printf("You have entered a positive number %d.\n", age_);

							System.out.println("Total: " + age_);

							System.out.println("Quantity\n");
							// String firstn_str = Utilities.getUserInput();
							Scanner quant = new Scanner(System.in);
							int amount_quantitiy;
							do {
								// System.out.print("Please enter a positive number: ");
								while (!quant.hasNextInt()) {
									String input = quant.next();
									System.out.printf("\"%s\" is not a valid number.\n", input);
								}
								amount_quantitiy = quant.nextInt();
							} while (amount_quantitiy < 0);

							System.out.println("Starting insert statement");
							// System.out.println(lastName_str);
							try {
								stmt = conn.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// variable with a sql statement as the value!
							String sqlInsert = "INSERT INTO " + tableName + " VALUES(0,'" + cusID + "','" + lastName_str
									+ "', '" + age_ + "','" + game_id + "', '" + amount_quantitiy + "')";
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

								break;
							case 3:

								break;
							case 4:

							default:
								System.out.print("Please enter a valid option 1, 2 or 3");

								break;
							}// end of switch

//
						} // end of while loop

//
//
//
//
//
					case 2:
						while (true) {
//WHEN OPTION 1 IS FIRST SELECTED THEN OPTION 2 IS SELECTED EG THIS COULD BE FOR ONLY MODIFIYING CUST INFO
							System.out.println("Obtain / Select Customer Info.\n");
							System.out.println("Enter Customer info\n");
							if (option == 4) {
								System.exit(0);
							}

							System.out.println("Enter PostCode of Customer\n");
							// Scanner fn = new Scanner(System.in);
							// String str = Utilities.getUserInput();
							String postalCode = Utilities.getUserInput();

							// String name = str;
							String postCode = postalCode;
							// fn.close();

							System.out.println("Creating select statement"); // '" + name + "' name is currently causing
																				// invalid sql syntax
							try {
								stmt = conn.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							// String sql2 = "SELECT
							// customerID,customerName,email,address,passwd,age,postCode from " + tableName
							// + "WHERE customerName = '"+name+"';";
							String sql2 = "SELECT customerID,customerName,email,address,postCode from " + tableName
									+ " WHERE postCode = '" + postCode + "';";
							ResultSet rs = null;
							try {
								rs = stmt.executeQuery(sql2);
								// System.out.println("what does RS print?"+rs);
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
							// WHEN OPTION 1 IS FIRST SELECTED THEN OPTION 2 IS SELECTED EG THIS COULD BE
							// FOR ONLY MODIFIYING CUST INFO
							System.out.println("Modify / Delete Customer Info.\n");
//													System.out.println(
//															"(1): Option 1 - something\n(2): Option 2 - something\n(3): Option 3 - something\n(4): Exit");
//													option = in.nextInt();
							System.out.println("Enter Customer info\n");
							if (option == 4) {
								System.exit(0);
							}

							System.out.println("Enter id of Customer\n");
							Scanner idofcust = new Scanner(System.in);

							// int age_ = ageofper.nextInt();

							int idval;
							do {
								// System.out.print("Please enter a positive number: ");
								while (!idofcust.hasNextInt()) {
									String input = idofcust.next();
									System.out.printf("\"%s\" is not a valid id.\n", input);
								}
								idval = idofcust.nextInt();
							} while (idval < 0);

							// System.out.printf("You have entered a positive number %d.\n", age_);

							// System.out.println("Age: " + age_);

							System.out.println("Creating delete statement"); // '" + name + "' name is currently causing
																				// invalid sql syntax
							try {
								stmt = conn.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							// String sql2 = "SELECT
							// customerID,customerName,email,address,passwd,age,postCode from " + tableName
							// + "WHERE customerName = '"+name+"';";

							String sql2 = "DELETE FROM gameorders WHERE customerID= " + idval + ";";
							// ResultSet rs = null;
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
}
