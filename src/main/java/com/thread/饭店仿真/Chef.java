/*
 * @文 件 名: Chef.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年6月11日 下午7:53:13
 */
package com.thread.饭店仿真;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: Chef.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年6月11日 下午7:53:13
 */
public class Chef implements Runnable {
	
	private static int			counter	= 0;
	private final int			id		= counter++;
	private final Restaurant	restaurant;
	private static Random		rand	= new Random(47);
	
	public Chef(Restaurant rest) {
		restaurant = rest;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Order order = restaurant.orders.take();
				Food requestedItem = order.item();
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				Plate plate = new Plate(order, requestedItem);
				order.getWaitPerson().filledOrders.put(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted ");
		}
		System.out.println(this + " off duty ");
	}
	
	public String toString() {
		return "Chef " + id + " ";
	}
}
