/*
 * @文 件 名: Main.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2017年4月28日 下午2:28:48
 */
package com.duoxiangshi;

import java.util.Scanner;

/**
 * @文 件 名: Main.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2017年4月28日 下午2:28:48
 */
public class Main {
	
	/**
	 * 
	 */
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		StringBuilder sb = new StringBuilder("f(x)=");
		for (int i = count; i >= 0; i--) {
			int tmp = scan.nextInt();
	 if (tmp > 0)
				sb.append(" +").append(tmp);
			else if (tmp == 0)
				continue;
			else
				sb.append(tmp);
			sb.append("x^").append(i);
		}
		String result = sb.toString().replace("= +", "=").replace("x^0", "").replace("x^1 ", "x ").replace("+1x", "+x").replace("-1x", "-x");
		System.out.println(result);
		scan.close();
	}
}
