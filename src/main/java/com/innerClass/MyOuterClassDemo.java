/*
 * @文 件 名: MyOuterClassDemo.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年4月28日 下午4:07:38
 */
package com.innerClass;

/**
 * @文 件 名: MyOuterClassDemo.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年4月28日 下午4:07:38
 */
public class MyOuterClassDemo {
	
	private int x = 1;
	
	public void doThings() {
		String name =null;// "local variable"; // name is effectively final
		
		// inner class defined inside a method of outer class
		class MyInnerClassDemo {
			
			public void seeOuter() {
				System.out.println("Outer Value of x is :" + x);
				System.out.println("Value of name is :" + name);
			} // close inner class method
		} // close inner class definition
		MyInnerClassDemo inner = new MyInnerClassDemo();
		inner.seeOuter();
	} // close Top level class method
	
	public static void main(String[] args) {
		MyOuterClassDemo outer = new MyOuterClassDemo();
		outer.doThings();
	}
}
