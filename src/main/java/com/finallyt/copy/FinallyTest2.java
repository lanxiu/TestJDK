package com.finallyt.copy;

public class FinallyTest2 {
	
	public static void main(String[] args) {
		System.out.println(test());
		System.out.println(test2());
	}

	public static int test() {
		int i = 1;
		try {
			return i++;
		} finally {
			return i++;
		}
	}
	public static int test2() {
		int i = 1;
		try {
			return print("dddd");
		} finally {
			return print("cccccc");
		}
	}
	public static int print(String aa) {
		int i = 1;
		try {
			System.out.println(aa);
			return 3;
		} finally {
			return 4;
		}
	}
}
