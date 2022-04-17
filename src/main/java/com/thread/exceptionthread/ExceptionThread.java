/*
 * @文 件 名: ExceptionThread.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年3月8日 上午9:11:59
 */
package com.thread.exceptionthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @文 件 名: ExceptionThread.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年3月8日 上午9:11:59
 */
public class ExceptionThread implements Runnable {
	
	@Override
	public void run() {
		throw new RuntimeException();
	}

	@Test(expected=RuntimeException.class)
	public void threadException() {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void catchException() {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
}
