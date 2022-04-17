/*
* @文 件 名:  Entrance.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月24日 下午4:00:06 
*/
package com.thread.cancelTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  Entrance.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月24日 下午4:00:06 
 */
public class Entrance implements Runnable {
	
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;
	// atomic operation on a volatiel field:
	public static void cancel () { canceled  = true; }
	public Entrance( int id) {
		this.id = id;
		entrances.add(this);
	}
	
	@Override
	public void run() {
		while(!canceled) {
			synchronized (this) {
				number  ++ ;
			}
			System.out.println( this +  " total : " + count.increment());
			try{
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Stopping " + this);
		
	}
	
	public synchronized int getValue() { return number; }
	
	public String toString() {
		return "Entrance " + id + " : " + getValue();
	}
	
	public static int getTotalCount() {
		return count.value();
	}
	public static int sumEntrances() {
		int sum = 0;
		for(Entrance entrance: entrances) {
			sum +=entrance.getValue();
		}
		return sum;
	}

}
