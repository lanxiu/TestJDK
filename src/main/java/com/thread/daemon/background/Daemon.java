/*
 * @文 件 名: Daemon.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午2:56:04
 */
package com.thread.daemon.background;

/**
 * @文 件 名: Daemon.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午2:56:04
 */
public class Daemon implements Runnable {
	
	private Thread[] t = new Thread[10];
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run1() {
		for (Thread thread : t) {
			thread = new Thread(new DaemonSpawn());
			thread.start();
			System.out.println(" daemon " + thread + "started ");
		}
		for (Thread thread : t) {
			System.out.print(thread + " is daemon ");
			System.out.println(thread.isDaemon());
		}
		while (true)
			Thread.yield();
	}
	
	@Override
	public void run() {
		Thread thread;
		for (int i = 0; i < t.length; i++) {
			thread = t[i];
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println(" daemon " + t[i] + "started ");
		}
		for (int i = 0; i < t.length; i++) {
			thread = t[i];
			System.out.print(thread + " is daemon ");
			System.out.println(thread.isDaemon());
		}
		while (true)
			Thread.yield();
	}
}
