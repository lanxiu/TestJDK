package com.finalstudy;


public class FinalTest {

	
	public static void main(String[] args) {
		
		String a = "hello2"; 
        final String b = "hello";
        String d = "hello";
        String c = b + 2; 
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == b));
        System.out.println((a == e));
	}
}
