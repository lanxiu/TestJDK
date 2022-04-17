/*
 * @文 件 名: EvenChecker.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: 
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年3月12日 下午2:57:49
 */
package com.thread.ResourceVisit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @文 件 名: EvenChecker.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: 
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年3月12日 下午2:57:49
 */
public class EvenChecker implements Runnable {
	
	private IntGenerator	generator;
	private final int		id;
	
	public EvenChecker(IntGenerator ig, int ident) {
		this.generator = ig;
		this.id = ident;
	}
	
	@Override
	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " not even!");
				generator.cancel();
			}
		}
	}
	
	public static void test(IntGenerator gp, int count) {
		System.out.println("press ctrl+c to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++)
			exec.execute(new EvenChecker(gp, i));
		exec.shutdown();
	}
	
	public static void test(IntGenerator ig) {
		test(ig, 10);
	}
}
