/*
* @文 件 名:  DaemonFromFactory.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月24日 下午3:04:43 
*/
package com.thread.daemon.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  DaemonFromFactory.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月24日 下午3:04:43 
 */
public class DaemonFromFactory  implements Runnable{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			} 
		}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool( new DaemonThreadFactory());
		for(int i = 0 ; i< 10; i ++) {
			exec.execute(new DaemonFromFactory());
		}
		
		System.out.println("all daemons start");
		TimeUnit.MILLISECONDS.sleep(400);
	
	}
	
	
	
	}
	
	
	
	
	
