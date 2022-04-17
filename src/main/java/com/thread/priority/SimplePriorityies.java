/*
 * @文 件 名: SimplePriorityies.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月24日 上午9:56:33
 */
package com.thread.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @文 件 名: SimplePriorityies.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月24日 上午9:56:33
 */
public class SimplePriorityies implements Runnable {

	public int				countDown	= 5;
	private volatile double	d;
	private int				priority;

	public SimplePriorityies(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return Thread.currentThread() + " : " + countDown;
	}

	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while (true) {
			// 此处使用浮点运算 及 d使编译器减少优化，否则看不到执行效果
			for (int i = 0; i < 100000; i++) {
				d += (Math.PI + Math.E) / (double) (i);
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i< 5 ; i ++)
			exec.execute(new SimplePriorityies(Thread.MIN_PRIORITY));
		exec.execute(new SimplePriorityies(Thread.MAX_PRIORITY));
		exec.shutdown();
	}
}
