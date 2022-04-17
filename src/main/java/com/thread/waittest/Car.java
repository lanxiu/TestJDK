/*
* @文 件 名:  Car.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月4日 下午7:29:00 
*/
package com.thread.waittest;


/**   
 * @文 件 名:  Car.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月4日 下午7:29:00 
 */
public class Car {
	
	
	private boolean waxOn = false;
	
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}
	
	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn == false) 
			wait();
	}
	
	public synchronized void waitForBuffing() throws InterruptedException{
		while(waxOn == true)
			wait();
	}
	
}
