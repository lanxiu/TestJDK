/*
 * @文 件 名: WaxOff.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月4日 下午7:39:18
 */
package com.thread.waittest;

import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: WaxOff.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月4日 下午7:39:18
 */
public class WaxOff implements Runnable {
	
	private Car c;
	
	public WaxOff(Car c) {
		this.c = c;
	}
	
	/**
	 * 功能简述:
	 * 
	 * @author 0216000799
	 * @version 1.0
	 * @since 1.0
	 */
	public void run() {
		try {
			while (Thread.interrupted() == false) {
				c.waitForWaxing();
				System.out.println(" wax off ");
				TimeUnit.MILLISECONDS.sleep(200);
				c.buffed();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" buffer end ");
	}
}
