/*
 * @文 件 名: VolatieTest.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年4月28日 上午9:56:49
 */
package com.volatileTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * @文 件 名: VolatieTest.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年4月28日 上午9:56:49
 */
public class VolatieTest {
	
	public volatile int inc = 0;

	public   void increase() {
		inc++;
		ai.getAndIncrement();
	}
	public synchronized void syncIncrease() {
		inc++;
	}
	ReentrantLock rl = new ReentrantLock();
	public   void lockIncrease() {
		rl.lock();
		inc++;
		rl.unlock();
	}
	
	public AtomicInteger ai = new AtomicInteger(0);
	
	
	

	@Test
	public void testOriginAtomic() throws Exception {
		final VolatieTest vt = new VolatieTest();
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
		es.execute(new Thread() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					vt.increase();
				}
			}
		});
		TimeUnit.SECONDS.sleep(3);
		System.out.println(Thread.activeCount());
//		 while(Thread.activeCount() > 1)
//		 Thread.yield();
		System.out.println(vt.inc);
		org.junit.Assert.assertNotEquals(vt.inc, 50000);
	}

	@Test
	public void testSyncAtomic() throws Exception {
		final VolatieTest vt = new VolatieTest();
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
		es.execute(new Thread() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					vt.syncIncrease();
				}
			}
		});
		TimeUnit.SECONDS.sleep(3);
		System.out.println(Thread.activeCount());
//		 while(Thread.activeCount() > 1)
//		 Thread.yield();
		System.out.println(vt.inc);
		org.junit.Assert.assertEquals(vt.inc, 50000);
	}
	@Test
	public void testLockAtomic() throws Exception {
		final VolatieTest vt = new VolatieTest();
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
		es.execute(new Thread() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					vt.lockIncrease();
				}
			}
		});
		TimeUnit.SECONDS.sleep(3);
		System.out.println(Thread.activeCount());
//		 while(Thread.activeCount() > 1)
//		 Thread.yield();
		System.out.println(vt.inc);
		org.junit.Assert.assertEquals(vt.inc, 50000);
	}
	@Test
	public void testJDKAtomic() throws Exception {
		final VolatieTest vt = new VolatieTest();
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
		es.execute(new Thread() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					vt.increase();
				}
			}
		});
		TimeUnit.SECONDS.sleep(3);
		System.out.println(Thread.activeCount());
//		 while(Thread.activeCount() > 1)
//		 Thread.yield();
		System.out.println(vt.ai.get());
		org.junit.Assert.assertEquals(vt.ai.get(), 50000);
	}
	
	@Test
	public void testSmallAtomic() throws Exception {
		final VolatieTest vt = new VolatieTest();
		for (int i = 0; i < 3; i++) {
			new Thread() {
				
				@Override
				public void run() {
					for (int i = 0; i < 1000; i++) {
						vt.increase();
					}
				};
			}.start();
			;
		}
		TimeUnit.SECONDS.sleep(10);
		System.out.println(Thread.activeCount());
		// while(Thread.activeCount() > 1)
		// Thread.yield();
		System.out.println(vt.inc);
		org.junit.Assert.assertEquals(vt.inc, 3000);
	}
	
	   public static void main(String[] args) {
	        final VolatieTest test = new VolatieTest();
	        for(int i=0;i<10;i++){
	            new Thread(){
	                public void run() {
	                    for(int j=0;j<10000;j++)
	                        test.increase();
	                };
	            }.start();
	        }
			System.out.println(Thread.activeCount());
	        while(Thread.activeCount()>1)  //保证前面的线程都执行完
	            Thread.yield();
	        System.out.println(test.inc);
	    }
}
