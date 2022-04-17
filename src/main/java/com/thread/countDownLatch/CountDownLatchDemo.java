/*
* @文 件 名:  CountDownLatchDemo.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月8日 下午9:08:46 
*/
package com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
 * @文 件 名:  CountDownLatchDemo.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月8日 下午9:08:46 
 */
public class CountDownLatchDemo {
	static final int SIZE = 100;
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(SIZE);
		for(int i = 0; i< 10 ; i++)
			exec.execute(new WaitingTasks(latch));
		
		for(int i=0;i<SIZE;i++)
			exec.execute(new TaskPortion(latch));
		System.out.println("Launtch all tasks");
		exec.shutdown();
	}

}
