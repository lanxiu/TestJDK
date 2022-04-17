/*
* @文 件 名:  Order.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月9日 上午10:58:25 
*/
package com.thread.饭店仿真;


/**   
 * @文 件 名:  Order.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月9日 上午10:58:25 
 */
public class Order {
	
	private static int counter = 0;
	private final int id = counter ++;
	private final Customer customer;
	private final WaitPerson waitPerson;
	private final Food food;
	
	public Order(Customer c,WaitPerson w , Food f) {
		this.customer = c;
		this.waitPerson = w;
		this.food = f;
	}
	
	public Food item() {
		return food;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public WaitPerson getWaitPerson() {
		return waitPerson;
	}
	
	public String toString() {
		return "Order : " + id + " item " + food + " for : " + customer + " served by : " + waitPerson ;
	}
	
	
	
	
	
	
	
}
