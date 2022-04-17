/*
 * @文 件 名: InnerThread1.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午8:25:33
 */
package com.thread.innerthread;

/**
 * @文 件 名: InnerThread1.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午8:25:33
 */
public class InnerThread2 {
	
	private int countDown = 5;
	
	public InnerThread2(String name) {
		Thread in = new Thread(name) {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					while (true) {
						System.out.println(this);
						if (--countDown == 0)
							return;
						sleep(10);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			public String toString() {
				return getName() + " : " + countDown;
			}
		};
		in.start();
	}
}
