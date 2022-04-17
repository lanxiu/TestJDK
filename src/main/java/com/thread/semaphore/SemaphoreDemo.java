/*
 * @文 件 名: SemaphoreDemo.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月15日 下午8:28:50
 */
package com.thread.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//import io.netty.util.concurrent.Future;

/**
 * @文 件 名: SemaphoreDemo.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月15日 下午8:28:50
 */
public class SemaphoreDemo {
	
	final static int SIZE = 25;
	
	public static void main(String[] args) throws Exception {
		final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < SIZE; i++)
			exec.execute(new CheckoutTask<Fat>(pool));
		System.out.println(" all checkout task created");
		List<Fat> list = new ArrayList<>();
		for (int i = 0; i < SIZE; i++) {
			Fat f = pool.checkOut();
			System.out.println(i + " : main thread checked out ");
			f.operation();
			list.add(f);
		}
		java.util.concurrent.Future<?> blocked = exec.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(" check 26 start");
					pool.checkOut();
					System.out.println(" check 26 end");
				} catch (InterruptedException e) {
				 e.printStackTrace();
				}
			}
		});
		TimeUnit.SECONDS.sleep(2);
		blocked.cancel(true);
		System.out.println(" chedking in objects in " + list);
		for (Fat f : list)
			pool.checkIn(f);
		for (Fat f : list)
			pool.checkIn(f);
		exec.shutdown();
	}
}
