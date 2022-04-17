/*
* @文 件 名:  HandlerThreadFactory.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月9日 下午3:57:18 
*/
package com.thread.exceptionthread.catchE;

import java.util.concurrent.ThreadFactory;

/**   
 * @文 件 名:  HandlerThreadFactory.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月9日 下午3:57:18 
 */
public class HandlerThreadFactory implements ThreadFactory{
	
	public Thread newThread(Runnable r) {
		System.out.println(this + "creating new thread");
		Thread t = new Thread(r);
		System.out.println("created " + t);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		System.out.println("eh factory = " + t.getUncaughtExceptionHandler());
		return t;
	}

}
