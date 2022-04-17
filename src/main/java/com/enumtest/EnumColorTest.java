package com.enumtest;

public class EnumColorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(EnumColor ec:EnumColor.values()) {
			System.out.println(ec.name());
			System.out.println(ec.ordinal());
			System.out.println(ec.toString());
			System.out.println(ec.count());
		}
		
		EnumColor ec1 = EnumColor.red ;
		
		switch(ec1) {
		case  red:
				System.out.println("111");
				break;
		
		
		}
		
		
	}

}
