/*
 * @文 件 名: TestBlockingQueue.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午9:51:24
 */
package com.thread.blokqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import com.thread.liftfoff.LiftOff;

/**
 * @文 件 名: TestBlockingQueue.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午9:51:24
 */
public class TestBlockingQueue {
	
	static void getKey() {
		try {
			new BufferedReader(new InputStreamReader(System.in, "utf-8")).readLine();
		} catch (IOException e) {
			System.out.println(" io error ");
		}
	}
	
	static void getKey(String message) {
		System.out.println(message);
		getKey();
	}
	
	static void test(String msg, BlockingQueue<LiftOff> queue) {
		System.out.println(msg);
		LiftOffRunner lor = new LiftOffRunner(queue);
		Thread t = new Thread(lor);
		t.start();
		for (int i = 0; i < 5; i++)
			lor.add(new LiftOff());
		getKey("print enter msg:" + msg);
		t.interrupt();
		System.out.println(" test end ");
	}
	
	public static void main(String[] args) {
		test("LinkedBlockingQueue", new LinkedBlockingQueue<>());
		test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
		test("SynconousQueue", new SynchronousQueue<>());
	}
}
