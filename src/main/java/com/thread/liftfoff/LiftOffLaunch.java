/*
 * @文 件 名: LiftOff.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月23日 下午8:18:55
 */
package com.thread.liftfoff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @文 件 名: LiftOff.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月23日 下午8:18:55
 */
public class LiftOffLaunch {
	
	private static int taskCount = 0;
	
	public static void main(String[] args) {
		LiftOffLaunch lof = new LiftOffLaunch();
		// lof.startByThread();
		// lof.startBySelf();
//		lof.startMore();
//		lof.startByExecutor();
//		lof.startByFixedExecutor();
		lof.startBySingleExecutor();
	}
	
	public void startByThread() {
		LiftOff lo = new LiftOff();
		Thread t = new Thread(lo);
		t.start();
		System.out.println("waiting for lift off ");
	}
	
	public void startBySelf() {
		LiftOff lo = new LiftOff();
		lo.run();
	}
	
	public void startMore() {
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println(" waiting for liftoff");
	}
	

	public void startByExecutor() {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
	public void startByFixedExecutor() {
		
		ExecutorService exec = Executors.newFixedThreadPool(3);
		for(int i = 0; i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
	public void startBySingleExecutor() {
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i = 0; i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
	

}
