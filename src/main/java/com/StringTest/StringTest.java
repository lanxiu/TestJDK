package com.StringTest;

public class StringTest {
	
	public static void main(String[] args) {
		
		String str2 = new String("str") + new String("01");
		str2.intern();
		String str1 = "str01";
		System.out.println(str1 == str2);// #7
	}
}
