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
public class InnerRunnable2 {
	
	public InnerRunnable2(String name) {
		Inner in = new Inner(name);
	}
	
	public class Inner implements Runnable {
		
		private int		countDown	= 5;
		private Thread	t;
		
		public Inner(String name) {
			t = new Thread(new Runnable() {

				@Override
				public String toString() {
					return  Thread.currentThread().getName() + " : " + countDown;
				}
				@Override
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
			});
			t.start();
		}
		
		@Override
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
		
	}
}
