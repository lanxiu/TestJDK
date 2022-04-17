/*
* @文 件 名:  Accessor.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月16日 下午8:46:12 
*/
package com.thread.threadLocal;

/**   
 * @文 件 名:  Accessor.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月16日 下午8:46:12 
 */
public class Accessor implements Runnable{

	private final int id;
	public Accessor(int idn ) {
		id = idn;
	}
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
//			threadlocalv
			ThreadLocalVarialbeHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	public String toString() {
		return "# " + id + " : " + ThreadLocalVarialbeHolder.get();
	}
}
