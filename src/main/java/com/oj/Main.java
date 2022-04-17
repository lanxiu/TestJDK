package com.oj;

import java.util.Scanner;

public class Main {
	static boolean[] used = new boolean[17];
	static int k;
	static int[][] ary = new int[4][4];
	static boolean found = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		for (int i = 1; i <= 16; i++)
			used[i] = false;
		if (k < 70) {
			recursion(0);
		} else {
			k -= 69;
			ary[0][0] = 1;
			ary[0][1] = 7;
			used[1] = true;
			used[7] = true;
			recursion(2);
		}
	}

	public static void recursion(int n) {
		int x = n / 4, y = n % 4;
		if (found)
			return;
		if (n == 16) {
			k--;
			if (k == 0) {
				printMagicSquare();
				found = true;
			}
			return;
		}
		for (int i = 1; i <= 16; i++) {
			if (!used[i]) {
				if (x == 3 && (ary[0][y] + ary[1][y] + ary[2][y] + i) != 34)
					continue;
				if (y == 3 && (ary[x][0] + ary[x][1] + ary[x][2] + i) != 34)
					continue;
				if (x == 3 && y == 0
						&& (ary[0][3] + ary[1][2] + ary[2][1] + i) != 34)
					continue;
				if (x == 3 && y == 3
						&& (ary[0][0] + ary[1][1] + ary[2][2] + i) != 34)
					continue;
				used[i] = true;
				ary[x][y] = i;
				recursion(n + 1);
				used[i] = false;
			}
		}
	}

	public static void printMagicSquare() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(ary[i][j] + " ");
			}
			System.out.println(ary[i][3]);
		}
	}
}