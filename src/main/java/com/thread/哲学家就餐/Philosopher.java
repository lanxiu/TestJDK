/*
 * @文 件 名: Philosopher.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月7日 下午8:25:53
 */
package com.thread.哲学家就餐;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

/**
 * @文 件 名: Philosopher.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月7日 下午8:25:53
 */
public class Philosopher implements Runnable {
	
	private Chopstick	left;
	private Chopstick	right;
	
	private int count = 0;
	
	private final int	id;
	private final int	ponderFactory;
	
	public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactory) {
		this.left = left;
		this.right = right;
		this.id = id;
		
		System.out.println( left +"**"+ right +"**" + id);
		
		this.ponderFactory = ponderFactory;
	}
	
	private void pause() throws InterruptedException {
		if (ponderFactory == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(new Random(47).nextInt(ponderFactory) * 100);
	}
	
	@Override
	public void run() {
		try {
			while (Thread.interrupted() == false) {
				this.pause();
				out.println(this + " " + "thinking");
				left.take();
				out.println(this + " " + "take left: " + left );
				right.take();
				out.println(this + " " + "take right" + right );
				pause();
				out.println(this + " " + "eatinging:" + count++);
				left.drop();
				right.drop();
			}
		} catch (InterruptedException e) {
			out.println(" interrupted");
		}
	}
	
	public String toString() {
		return "phiosoper " + id;
	}
}
