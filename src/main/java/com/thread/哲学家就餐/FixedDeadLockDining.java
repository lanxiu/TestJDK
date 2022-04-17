/*
 * @文 件 名: DeadLockDining.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月7日 下午8:36:59
 */
package com.thread.哲学家就餐;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @文 件 名: DeadLockDining.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月7日 下午8:36:59
 */
public class FixedDeadLockDining {
	
	public static void main(String[] args) throws Exception {
		int ponder = 2;
		int size = 5;
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for (int i = 0; i < size; i++)
			sticks[i] = new Chopstick(i);
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				exec.execute(new Philosopher(sticks[0], sticks[(size - 1) % size], i, ponder));
				continue;
			}
			exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
		}
		System.out.println("print enter to quit ");
		System.in.read();
		exec.shutdownNow();
	}
}
