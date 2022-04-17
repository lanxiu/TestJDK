/*
* @文 件 名:  MyUncaughtExceptionHandler.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月9日 下午3:46:43 
*/
package com.thread.exceptionthread.catchE;

/**   
 * @文 件 名:  MyUncaughtExceptionHandler.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月9日 下午3:46:44 
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {

		System.out.println("caught " + e);
	}
}
