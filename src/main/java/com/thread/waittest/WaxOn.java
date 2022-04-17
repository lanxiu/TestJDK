/*
 * @文 件 名: WaxOn.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月4日 下午7:35:33
 */
package com.thread.waittest;

import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: WaxOn.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月4日 下午7:35:33
 */
public class WaxOn implements Runnable {
	
	private Car c;
	
	public WaxOn(Car c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		try {
			while (Thread.interrupted() == false) {
				System.out.println(" wax start ");
				TimeUnit.MILLISECONDS.sleep(200);
				c.waxed();
				c.waitForBuffing();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		System.out.println("wax end");
	}
}
