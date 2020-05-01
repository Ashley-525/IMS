package com.qa.sqlExample;

import java.util.Scanner;

public class GetInputFromUser {
	
	
	private static String str;
	private static String strSurname;
	private static String emailStr;
	private static String addresStr;
	private static int age_;
	private static String postC;

    
    
    
	public static String getStr() {

		return str;
	}
	public /*static*/ void setStr(String newStr) {

		this.str = newStr;
	}
	
	public static String getSurname() {

		return strSurname;
	}
	public /*static*/ void setSurname(String newStrSurname) {

		this.strSurname = newStrSurname;
	}
	
	public /*static*/ void getAddress(String newStrAddress) {

		this.addresStr = newStrAddress;
	}
	
	
	
	public /*static*/ void setAddress(String newStrAddress) {

		this.addresStr = newStrAddress;
	}
	
	public static String getEmailAdd() {

		return emailStr;
	}
	
	public /*static*/ void setEmail(String newStrEmail) {

		this.emailStr = newStrEmail;
	}
	
	public /*static*/ void getPCode(String newStrPCode) {

		this.postC = newStrPCode;
	}
	
	public /*static*/ void setPCode(String newStrPCode) {

		this.postC = newStrPCode;
	}
	
	
	public static int getAge() {

		return age_;
	}
	public /*static*/ void getAge(int newStrAge) {

		this.age_ = newStrAge;
	}
	

	public /*static*/ void getEmailAdd(String newStrEmail) {

		this.emailStr = newStrEmail;
	}
		
		
}
