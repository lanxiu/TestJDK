/*
* @文 件 名:  ExceptionThread2.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月8日 上午10:38:51 
*/
package com.thread.exceptionthread.catchE;


/**   
 * @文 件 名:  ExceptionThread2.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月8日 上午10:38:51 
 */
public class ExceptionThread2 implements Runnable{

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("run () by " + t);
		System.out.println(" eh thread = " + t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}

}
