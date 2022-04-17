package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class 九宫格2 {
	int arr[][] = new int[4][4];
	List<Integer> lst = new ArrayList<Integer>();

	public static void main(String[] args) {

		Stack<Integer> v = new Stack<Integer>();
		for (int i = 1; i <= 16; i++)
			v.push(i);
		九宫格2 黄蓉 = new 九宫格2();
		黄蓉.幻方(0);

	}

	private void 幻方(int line) {

		if (line == 4 && 符合行条件()) {
			lst.clear();
			System.out.println("----------------");
			for (int i1 = 0; i1 <= 3; i1++) {
				System.out.println();
				for (int j4 = 0; j4 <= 3; j4++)
					System.out.print(arr[i1][j4] + " ");
			}
		}
		if (line == 4) {
			return;
		}

		for (int i = 1; i <= 16; i++) {

			arr[line][0] = i;
			lst.add(i);
			for (int j = 1; j <= 16; j++) {
				if (lst.contains(j))
					continue;
				arr[line][1] = j;
				lst.add(j);
				for (int j2 = 1; j2 <= 16; j2++) {
					if (lst.contains(j2))
						continue;
					arr[line][2] = j2;
					lst.add(j2);
					for (int j3 = 1; j3 <= 16; j3++) {
						if (lst.contains(j3))
							continue;
						arr[line][3] = j3;

						if (arr[line][0] + arr[line][1] + arr[line][2]
								+ arr[line][3] != 34)
							continue;
						lst.add(j3);
						幻方(line + 1);
						return;
					}
				}
			}
		}
	}

	private boolean 符合行条件() {

		for (int i = 0; i <= 3; i++) {

			if (arr[i][0] + arr[i][1] + arr[i][2] + arr[i][3] != 34)
				return false;
			if (arr[0][i] + arr[1][i] + arr[2][i] + arr[3][i] != 34)
				return false;
		}

		return true;
	}
}
