/*
* @文 件 名:  TaskPortion.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月8日 下午8:58:07 
*/
package com.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  TaskPortion.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月8日 下午8:58:07 
 */
public class TaskPortion implements Runnable {

	
	private static int counter = 0;
	private final int id = counter ++;
	private static Random rand = new Random(47);
	private final CountDownLatch latch ;
	
	
	/**  */
	public TaskPortion(CountDownLatch latch) {
		this.latch  = latch;
	}
		
	
	@Override
	public void run() {
		
		try{
			doWork();
			latch.countDown();
		} catch (InterruptedException e) {
			System.out.println( this + " interrupted ");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%1$-3d ", id);
	}
	
	void doWork() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
		System.out.println(this + "completed");
	}
	
	
}
