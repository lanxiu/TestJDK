/*
* @文 件 名:  ThreadVariations.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月27日 下午8:54:18 
*/
package com.thread.innerthread;


/**   
 * @文 件 名:  ThreadVariations.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月27日 下午8:54:18 
 */
public class ThreadVariations {
	public static void main(String[] args) {
		new InnerRunnable1(" inner runalbe1");
		new InnerRunnable2(" inner runalbe2");
		new InnerThread1( " inner thread1");
		new InnerThread2( " inner thread2");
		new ThreadMethod("thread method").runTask();
		
	}
}
