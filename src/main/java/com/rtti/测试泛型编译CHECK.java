package com.rtti;

import com.inout.Inout;

public class 测试泛型编译CHECK {

	static void test1() {

		Class tt = Son.class;
		Class<Son> t2 = tt.getSuperclass();
		try {
			t2.newInstance();
			 
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***");
		System.out.println("Test1 END");
		
	}
	static void test2() {

		Class tt = Son.class;
		tt.isAssignableFrom(tt);
 	Class<Father> t2 = tt.getSuperclass();
 
		try {
			t2.newInstance();
			 
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***");
		System.out.println("Test2 END");
		
	}
	
	/**
	 * 不会报错，why
	 */
	static void test3() {

		Class tt = Son.class;
		tt = Inout.class;
		Class<测试泛型编译CHECK> t2 = tt.getSuperclass();
		try {
			t2.newInstance();
			 
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***");
		System.out.println("Test3 END");
		
	}
	static void test4() {

		Class tt = Son.class;
		Son ss =new Son();
		Class<? extends Son> t2 =  ss.getClass();
		try {
			t2.newInstance();
			 
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("***");
		System.out.println("Test3 END");
		
	}
	
	
	public static void main(String[] args)  {

		 测试泛型编译CHECK.test3();
		 测试泛型编译CHECK.test1();
		 测试泛型编译CHECK.test2();
	}

	
}

  class Father{
	  static {
		  System.out.println("father");
	  }
	  public Father() {
		  System.out.println("create father");
	  }
	
}
  
  class Son extends Father{
	  static {
		  System.out.println("son");
	  }
	
	  
  }