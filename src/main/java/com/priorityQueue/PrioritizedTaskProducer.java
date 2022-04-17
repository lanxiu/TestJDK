/*
* @文 件 名:  DelayedTaskConsumer.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月12日 上午9:59:50 
*/
package com.priorityQueue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  DelayedTaskConsumer.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月12日 上午9:59:50 
 */
public class PrioritizedTaskProducer implements Runnable {
	private Random rand  = new Random(47);
	private Queue<Runnable> queue;
	private ExecutorService exec;
	
	
	/**  */
	public PrioritizedTaskProducer(Queue<Runnable> q,ExecutorService e) {
		this.queue = q;
		this.exec =e;
	}
	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			queue.add(new PrioritizedTask(rand.nextInt(10)));
			Thread.yield();
		}
		
		try {
			for(int i=0;i<10;i++) {
				TimeUnit.MILLISECONDS.sleep(250);
				queue.add(new PrioritizedTask(10));
			}
			for(int i=0;i<10;i++) {
				queue.add(new PrioritizedTask(i));
			}
			queue.add(new PrioritizedTask.EndSentinel(exec));
		} catch (InterruptedException e) {
			System.out.println(this + "interrupted");
		}
		System.out.println("finished producer");
	}
}
