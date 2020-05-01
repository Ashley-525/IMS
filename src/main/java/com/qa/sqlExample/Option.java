package com.qa.sqlExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import com.aq.sql.dbconnection.db;
import com.qa.sqlExample.gameStock.GameInvStock;
import com.qa.sqlExample.orderSwitch.OrderSwitchCase;
import com.qa.utilities.Utilities;
import com.qa.sqlExample.gameStock.GameInvStock;


public class Option {
	public Option(){
		
	}
	//public static void main(String[] args) {
	public void Option1() {
		
		OrderSwitchCase osc = new OrderSwitchCase();
		GameInvStock gvs = new GameInvStock();
		GetInputFromUser fistName = new GetInputFromUser();
		GetInputFromUser surname = new GetInputFromUser();
		GetInputFromUser _age = new GetInputFromUser();
		GetInputFromUser email = new GetInputFromUser();
		GetInputFromUser phoneNo = new GetInputFromUser();
		GetInputFromUser passwd = new GetInputFromUser();
		GetInputFromUser pCode = new GetInputFromUser();
		GetInputFromUser address = new GetInputFromUser();

		System.out.println("Hello, and welcome to this Inventory Application.");
		// System.out.println("The getStr value is: " + getStr());

		// Runner2 class in Runner2.java with an obje variable assigned creates a new
		// method called Runner2
		// This can interact with the Runner2 class to save information being copied
		// over

		// Prompts for user input of blank fields if not commented.
//		Runner2 obje = new Runner2();
//		GetInputFromUser objec = new GetInputFromUser();

		// System.out.println(obje.mainUser);
		String JDBCDRV = Database_Interaction.JDBC_DRIVER;
		String DB_URL = Database_Interaction.DB_URL;
		String USER = Database_Interaction.USER;
		String PASS = Database_Interaction.PASS;

		String tableName = "gamecustomers";

		/// placeholder remove these after testing
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
		String Opt1 = "Customers";
		String Opt2 = "Orders";
		String Opt3 = "Inventory";
		while (true) {
			System.out.println("Choose which Data you'd like to modify\n");
			System.out.println(
					"(1): Option 1 - " +Opt1+"\n(2): Option 2 - " + Opt2 + "\n(3): Option 3 - " + Opt3 + "\n(4): Exit");
			System.out.println("Enter a Choice: ");
			option = in.nextInt();

			if (option == 4) {
				System.exit(0);
			}

//			if (option == 2) {
//				//com.qa.sqlExample.orderSwitch.OrderSwitchCase osc1 = new com.qa.sqlExample.orderSwitch.OrderSwitchCase();
//
//			}


			switch (option) {

			case 1:
				System.out.println("you Selected Customer Data");

				while (true) {
					System.out.println("Choose which data to insert\n");
					System.out.println(
							"(1): Option 1 - insert customer info\n(2): Option 2 - Obtain customer info\n(3): Option 3 - delete customer info\n(4): Exit\n(5): Modify Customer Info\\n");
					option = in.nextInt();

					if (option == 5) {

					}
					// call a method of 1 switch statement and call another method which contains
					// another switch statement
					if (option == 4) {
						System.exit(0);
						switch (option) {

						case 1:
							System.out.println("Test Case1");
							break;
						case 2:
							System.out.println("Test Case2");
							break;
						case 3:

							break;
						case 4:

							break;
						case 5:
							break;
						}
					}

					switch (option) {

					case 1:

						while (true) {
							System.out.println("Enter First Name\n");
							String firstn_str = /* fn.nextLine(); */ Utilities.getUserInput();

							fistName.setStr(firstn_str);

							System.out.println("a different way of printing " + com.qa.sqlExample.GetInputFromUser.getStr());
							// System.out.println("str is... hopefully not null value " + firstn_str);

							System.out.println("First Name: " + firstn_str);

							System.out.println("Enter Surname\n");

							String lastName_str = Utilities.getUserInput();

							surname.setSurname(lastName_str);

							System.out.println("Surname Name: " + lastName_str);

							System.out.println("Enter Age\n");
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

							System.out.println("Enter Address\n");
							// Scanner ad = new Scanner(System.in);

							String addres_Str = Utilities.getUserInput();

							address.setAddress(addres_Str);

							System.out.println("Address: " + addres_Str);

							System.out.println("Postcode (Include a space)\n");

							System.out.println("Enter POSTCODE\n");
							// Scanner pc = new Scanner(System.in);

							String postcode_Str = Utilities.getUserInput();

							pCode.setPCode(postcode_Str);

							System.out.println("Post Code: " + postcode_Str);

							System.out.println("Email\n");

							System.out.println("Enter email\n");

							String email_Str = Utilities.getUserInput();

							email.setAddress(email_Str);

							System.out.println("Email Address: " + email_Str);

							System.out.println("Phone number (mobile or landline)\n");
							// Scanner phone = new Scanner(System.in);

							// String phoneNo = phone.nextLine();
							System.out.println("Phone Number: " + phoneNo);

							String password = "password";
							int age = age_;

							System.out.println("Starting insert statement");

							try {
								stmt = conn.createStatement();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							// variable with a sql statement as the value!
							String sqlInsert = "INSERT INTO " + tableName + " VALUES(0,'" + firstn_str + "','"
									+ lastName_str + "', '" + addres_Str + "','" + password + "','" + email_Str + "','"
									+ age + "','" + postcode_Str + "')";
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

							String postalCode = Utilities.getUserInput();

							String postCode = postalCode;

							System.out.println("Creating select statement"); // '" + name + "' name is currently causing
																				// invalid sql syntax
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
							// WHEN OPTION 1 IS FIRST SELECTED THEN OPTION 2 IS SELECTED EG THIS COULD BE
							// FOR ONLY MODIFIYING CUST INFO
							System.out.println("Modify / Delete Customer Info.\n");
//														System.out.println(
//																"(1): Option 1 - something\n(2): Option 2 - something\n(3): Option 3 - something\n(4): Exit");
//														option = in.nextInt();
							System.out.println("Enter Customer info\n");
							if (option == 4) {
								System.exit(0);
							}

							System.out.println("Enter id of Customer\n");

							Scanner idofcust = new Scanner(System.in);

							int idval;
							do {
								// System.out.print("Please enter a positive number: ");
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

							String sql2 = "DELETE FROM gamecustomers WHERE customerID= " + idval + ";";

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

						// break;
					default:
						System.out.print("Please enter a valid option 1, 2 or 3");
						break;
					}// end of switch

				}
			case 2:
				System.out.println("Test this should exit when executed");
				// method to run Order Method here
				OrderSwitchCase osc1 = new OrderSwitchCase();
				osc1.OrderSwitchCase_();
				// System.exit(0);

				break;
				
			case 3:
				gvs.Game_Inventory();
			}
				// System.exit(0);

				break;
			}

		}

	}

