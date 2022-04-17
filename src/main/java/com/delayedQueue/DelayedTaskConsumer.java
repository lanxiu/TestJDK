/*
* @文 件 名:  DelayedTaskConsumer.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月12日 上午9:59:50 
*/
package com.delayedQueue;

import java.util.concurrent.DelayQueue;

/**   
 * @文 件 名:  DelayedTaskConsumer.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月12日 上午9:59:50 
 */
public class DelayedTaskConsumer implements Runnable {
	
	private DelayQueue<DelayedTask> q;
	
	/**  */
	public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
		this.q =q;
	}
	@Override
	public void run() {
		try{
			while (!Thread.interrupted()) 
				q.take().run();
		} catch (InterruptedException e) {
			System.out.println("consumer interrupted ");
		}
		System.out.println("finished consumer ");
	}
}
