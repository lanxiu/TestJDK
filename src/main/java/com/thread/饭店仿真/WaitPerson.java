/*
* @文 件 名:  WaitPerson.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月9日 上午11:00:04 
*/
package com.thread.饭店仿真;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**   
 * @文 件 名:  WaitPerson.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月9日 上午11:00:04 
 */
public class WaitPerson  implements Runnable {
	
	private static int counter = 0;
	private final int id = counter ++;
	private final Restaurant restaurant;
	BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();
	
	public WaitPerson(Restaurant rest) {
		restaurant = rest;
	}
	
	public void placeOrder(Customer cust,Food food) {
		try{
			restaurant.orders.put(new Order(cust, this, food));
		} catch(InterruptedException e) {
			System.out.println(this + " placeorder interrupted ");
		}
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Plate plate = filledOrders.take();
				System.out.println(this + " received " + plate + " delivering go " + plate.getOrder().getCustomer() );
				plate.getOrder().getCustomer().deliver(plate);
				
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted " );
		}
		System.out.println( this  + " off duty ");
	}

	public String toString() {
		return "WaitPerson " + id + "  ";
	}
	

}


