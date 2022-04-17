package com.oj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fang {
	
	int				arr[][]	= new int[4][4];
	List<Integer>	lst		= new ArrayList<>();
	int				i		= 0;
	int				k		= 0, ak = 0;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int ak = input.nextInt();
		fang aa = new fang();
		for (int i = 1; i <= 16; i++) {
			aa.lst.add(0);
		}
		aa.ff(0);
	}
	
	private void ff(int line) {
		
		if (line == 4 && 符合行条件()) {
			k++;
			if (k == ak)
				for (int i1 = 0; i1 <= 3; i1++) {
					for (int j4 = 0; j4 <= 3; j4++)
						System.out.print(lst.get(i1 * 4 + j4) + " ");
					System.out.println();
				}
		}
		if (line == 4) {
			return;
		}
		for (int i = 1; i <= 16; i++) {
			this.clear(line * 4 + 0);
			if (lst.contains(i))
				continue;
			lst.set(line * 4 + 0, i);
			for (int j = 1; j <= 16; j++) {
				this.clear(line * 4 + 1);
				if (lst.contains(j))
					continue;
				lst.set(line * 4 + 1, j);
				for (int j2 = 1; j2 <= 16; j2++) {
					this.clear(line * 4 + 2);
					if (lst.contains(j2))
						continue;
					lst.set(line * 4 + 2, j2);
					for (int j3 = 1; j3 <= 16; j3++) {
						this.clear(line * 4 + 3);
						if (lst.contains(j3))
							continue;
						lst.set(line * 4 + 3, j3);
						if (lst.get(line * 4 + 0) + lst.get(line * 4 + 1) + lst.get(line * 4 + 2)
								+ lst.get(line * 4 + 3) != 34)
							continue;
						ff(line + 1);
					}
				}
			}
		}
	}
	
	private boolean 符合行条件() {
		
		for (int i = 0; i <= 3; i++) {
			if (lst.get(+i) + lst.get((1) * 4 + i) + lst.get((2) * 4 + i) + lst.get((3) * 4 + i) != 34)
				return false;
		}
		if (lst.get(0) + lst.get(5) + lst.get(10) + lst.get(15) != 34)
			return false;
		if (lst.get(4) + lst.get(6) + lst.get(9) + lst.get(12) != 34)
			return false;
		return true;
	}
	
	private void clear(int n) {
		
		for (int i = n + 1; i <= 15; i++)
			lst.set(i, 0);
	}
}
