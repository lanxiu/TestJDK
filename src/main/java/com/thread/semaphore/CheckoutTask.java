/*
 * @文 件 名: CheckoutTask.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月15日 下午8:25:09
 */
package com.thread.semaphore;

import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: CheckoutTask.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月15日 下午8:25:09
 */
public class CheckoutTask<T> implements Runnable {
	
	private static int	counter	= 0;
	private final int	id		= counter++;
	private Pool<T>		pool;
	
	/**  */
	public CheckoutTask(Pool<T> pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		try {
			T item = pool.checkOut();
			System.out.println(this + "checked out " + item);
			TimeUnit.SECONDS.sleep(1);
			System.out.println(this + "checking in " + item);
			pool.checkIn(item);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " checkout task " + id + " ";
	}
}
