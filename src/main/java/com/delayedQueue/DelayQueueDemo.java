/*
* @文 件 名:  DelayQueueDemo.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月12日 上午10:13:37 
*/
package com.delayedQueue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
 * @文 件 名:  DelayQueueDemo.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月12日 上午10:13:37 
 */
public class DelayQueueDemo {

	public static void main(String[] args) {
		Random rand = new Random(47);
		ExecutorService exec = Executors.newCachedThreadPool();
		DelayQueue< DelayedTask> queue = new DelayQueue<>();
		for(int i =0 ;i<20 ; i++)
			queue.put(new DelayedTask(rand.nextInt(5000)));
		queue.add(new DelayedTask.EndSentinel(5000, exec));
		exec.execute(new DelayedTaskConsumer(queue));
	}

}
