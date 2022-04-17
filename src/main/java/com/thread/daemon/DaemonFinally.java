/*
* @文 件 名:  DaemonFinally.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月26日 下午4:38:22 
*/
package com.thread.daemon;

import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  DaemonFinally.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  后台线程会突然被终止，不会有任何确认形式，因此不够优雅，相对的Exector是一种更好的方式，可以控制所有任务被有序的关闭
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月26日 下午4:38:22 
 */
public class DaemonFinally implements Runnable{
	private Thread t = new Thread(this);
	
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonFinally());
		t.setDaemon(true);
		t.start();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		try {
			System.out.println("starting a daemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("this should always run? ");
		}
		
	}
	
}
