/*
* @文 件 名:  Chopstick.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月7日 下午8:22:24 
*/
package com.thread.哲学家就餐;

/**   
 * @文 件 名:  Chopstick.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月7日 下午8:22:24 
 */
public class Chopstick {
	
	private final int id;
	
	
	/**  */
	public Chopstick(int id ) {
		this.id = id;
	}
	
	private boolean taken = false;
	
	synchronized void take() throws InterruptedException{
		while(taken)
			wait();
		taken = true;
	}
	
	public synchronized void drop() {
		taken = false;
		notifyAll();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  " chopstick: " + id;
	}
	
}
