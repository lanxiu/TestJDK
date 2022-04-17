/*
* @文 件 名:  Customer.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月9日 下午4:02:40 
*/
package com.thread.饭店仿真;

import java.util.concurrent.SynchronousQueue;

/**   
 * @文 件 名:  Customer.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月9日 下午4:02:40 
 */
public class Customer implements Runnable{
	
	private static int counter = 0;
	private final int id = counter ++;
	private final WaitPerson waitPerson;
	
	private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();
	public Customer(WaitPerson w ) {
		waitPerson = w;
	}
	
	public void deliver(Plate p) throws InterruptedException {
		placeSetting.put(p);
	}
	
	@Override
	public void run() {
		for(Course course:Course.values()) {
			
			Food food = course.randomSelection();
			
			try {
				waitPerson.placeOrder(this, food);
				System.out.println(this + " eating " + placeSetting.take());
			} catch (InterruptedException e) {
				System.out.println(this + " waiting for " + course + " interrupted ");
			}
		}
		System.out.println( this + " finished meal , leaving ");
	}

	public String toString() {
		return  "Customer " + id + " "; 
	}
}
