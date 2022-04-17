/*
* @文 件 名:  Teller.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月31日 下午3:16:03 
*/
package com.thread.出纳员;

import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  Teller.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月31日 下午3:16:03 
 */
public class Teller implements Runnable,Comparable<Teller> {

	private static int counter = 0;
	private final int id = counter ++ ;
	private int customersServed = 0;
	private CustomerLine customers;
	private boolean servingCustomerLine = true;
	public Teller(CustomerLine cq) {
		customers = cq;
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Customer customer = customers.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				synchronized (this) {
				customersServed ++;
				while(!servingCustomerLine) 
					wait();
				}
			}
		} catch (InterruptedException  e) {
			System.out.println(this + " interrupted");
		}
		System.out.println(this + " terminating ");
	}
	
	public synchronized void doSomethingElse() {
		customersServed = 0;
		servingCustomerLine = false;
	}
	
	public synchronized void serveCustomerLine() {
		assert !servingCustomerLine : "already serving : " + this;
		servingCustomerLine = true;
		notifyAll();
	}

	
	/**   
	 * 功能简述:  
	 * @author  0216000799
	 * @version  1.0
	 * @since 1.0
	 *
	 */
	public String tostring() {
		return "teller " + id + " "; 
	}
	
	public String shortString() {
		return "T" + id;
	}
	
	public synchronized int compareTo(Teller other) {
		return customersServed < other.customersServed ? -1 :(customersServed == other.customersServed ? 0:1);
	}
	
}
