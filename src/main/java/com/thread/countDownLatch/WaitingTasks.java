/*
 * @文 件 名: WaitingTasks.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月8日 下午9:04:52
 */
package com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @文 件 名: WaitingTasks.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月8日 下午9:04:52
 */
public class WaitingTasks implements Runnable {
	
	private static int				counter	= 0;
	private final int				id		= counter++;
	private final CountDownLatch	latch;
	
	/**  */
	public WaitingTasks(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		try {
			latch.await();
			System.out.println("Latch barrier passed for " + this);
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("waitingTask %1$-3d ", id);
	}
	
}
