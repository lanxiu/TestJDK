/*
 * @文 件 名: Toaster.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午10:34:49
 */
package com.thread.blokqueue.toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: Toaster.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午10:34:49
 */
public class Toaster implements Runnable {
	
	private ToasterQueue	toasteQueue;
	private int				count	= 0;
	private Random			random	= new Random(47);
	
	public Toaster(ToasterQueue tq) {
		this.toasteQueue = tq;
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
				TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
				Toast t = new Toast(count++);
				System.out.println(t);
				toasteQueue.add(t);
			}
		} catch (InterruptedException e) {
			System.out.println("toast interrupted ");
		}
		System.out.println("toast end ");
	}
}
