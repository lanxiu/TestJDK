/*
* @文 件 名:  ThreadLocalVarialbeHolder.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月16日 下午8:51:40 
*/
package com.thread.threadLocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  ThreadLocalVarialbeHolder.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月16日 下午8:51:40 
 */
public class ThreadLocalVarialbeHolder {

	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random rand = new Random(47);
		protected synchronized Integer initialValue() {
			return rand.nextInt(10000);
		}
	};
	
	public static void increment() {
		value.set(value.get() + 1);
	}

	public static int get() {return value.get();};
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i= 0; i<5; i++ ) {
			exec.execute(new Accessor(i));
		}
		System.out.println("*****");
		TimeUnit.MILLISECONDS.sleep(3);
		System.out.println("*****22");
		exec.shutdownNow();
		System.out.println("*****333");
	}

}
