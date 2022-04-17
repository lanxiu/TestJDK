/*
* @文 件 名:  VectorNotSafe.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2017年11月21日 上午9:06:50 
*/
package com.vector;

import java.util.Vector;

/**   
 * @文 件 名:  VectorNotSafe.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2017年11月21日 上午9:06:50 
 */
public class VectorNotSafe {
	
	static Vector< String> vNotSafe = new Vector<>();
	
	
	public VectorNotSafe() {
		this.vNotSafe.add("bb");
	}

	public static void getLast() {
		System.out.println("get last");
		int lastIndex = vNotSafe.size();
		
		
		
		if (lastIndex != 0)
			vNotSafe.get(lastIndex);
	}
	
	public static void deleteLast() {
		System.out.println("delete last");
		int lastIndex = vNotSafe.size();
		if (lastIndex == 0) {
			vNotSafe.add("aa");
			System.out.println("添加 ");
		}
			

			vNotSafe.remove(lastIndex);
	}
}
