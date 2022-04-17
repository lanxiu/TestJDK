/*
 * @文 件 名: InnerThread1.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午8:25:33
 */
package com.thread.innerthread;

import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: InnerThread1.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午8:25:33
 */
public class ThreadMethod {
	private int countDown = 5;
	
	private Thread t;
	private String name;
	
	/**
	 * 
	 */
	public ThreadMethod(String name) {
		this.name = name;
	}
	
	public void runTask () {
		if(t== null) {
			t = new Thread(name) {
				public void run() {
					try {
						while (true) {
							System.out.println(this);
							if (--countDown == 0)
								return;
							TimeUnit.SECONDS.sleep(10);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				public String toString() {
					return  Thread.currentThread().getName() + " : " + countDown;
				}
			};
			t.start();
		}
	}
}
