package com.qa.utilities;

import java.util.Scanner;

public class Utilities {
	
	public static final Scanner SCANNER = new Scanner(System.in);
	
	public static String getUserInput() {
		return SCANNER.nextLine();
	}
	

}
