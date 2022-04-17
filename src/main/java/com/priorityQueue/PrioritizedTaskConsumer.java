/*
 * @文 件 名: PrioritizedTaskConsumer.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月14日 下午6:44:36
 */
package com.priorityQueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @文 件 名: PrioritizedTaskConsumer.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月14日 下午6:44:36
 */
public class PrioritizedTaskConsumer implements Runnable {
	
	private PriorityBlockingQueue<Runnable> q;
	
	public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> p) {
		q = p;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted())
				q.take().run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" finished consumer ");
	}
}
