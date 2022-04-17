/*
* @文 件 名:  Plate.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月9日 下午3:58:32 
*/
package com.thread.饭店仿真;


/**   
 * @文 件 名:  Plate.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月9日 下午3:58:32 
 */
public class Plate {
	
	private final Order order;
	private final Food food;
	public Plate(Order ord,Food f) {
		this.order = ord;
		this.food = f;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public Food getFood() {
		return food;
	}
	
	public String toString (){
		return food.toString();
	}
	
}
