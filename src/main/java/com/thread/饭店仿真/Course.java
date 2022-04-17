/*
* @文 件 名:  Course.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月9日 下午4:14:21 
*/
package com.thread.饭店仿真;


/**   
 * @文 件 名:  Course.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月9日 下午4:14:21 
 */
public enum Course {
	
	APPETIZER(Food.Appetizer.class);
	
	private Food [] values ;
	private Course(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}
	
	public Food randomSelection() {
		return Enums.random(values);
	}
	
}
