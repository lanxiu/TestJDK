package com.random;

import java.util.Random;

public class RandomTest {
	static void test() {
		Random rd = new Random(47);
		for(int i= 0;i<3;i++)
		System.out.println(rd.nextInt(6));;
	}
	public static void main(String[] args) {
		test();
		System.out.println("****");
		test();
	}

}
