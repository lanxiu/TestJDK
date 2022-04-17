/*
 * @文 件 名: LiftOffSleep.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月24日 上午9:41:25
 */
package com.thread.liftfoff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: LiftOffSleep.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月24日 上午9:41:25
 */
public class LiftOffSleep extends LiftOff {
	
	public void run() {
		try {
			while (countDown-- > 0) {
				System.out.println(status());
				TimeUnit.MICROSECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOffSleep());
		}
		exec.shutdown();
	}
}
