/*
* @文 件 名:  CUstomerGenerator.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月31日 下午3:06:46 
*/
package com.thread.出纳员;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  CUstomerGenerator.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月31日 下午3:06:46 
 */
public class CustomerGenerator implements Runnable{
	private CustomerLine customers;
	private static Random rand = new Random(47);
	
	/**  */
	public CustomerGenerator(CustomerLine cq) {
		customers = cq;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
				customers.put(new Customer(rand.nextInt(1000)));
			}
		} catch (InterruptedException e) {
			System.out.println("CustomerGenerator interrupted");
		}
		System.out.println("CUstomerGenerator terminating ");
	}
	
}
