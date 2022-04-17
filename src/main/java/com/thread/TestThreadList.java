/*
 * @文 件 名: TestThreadArray.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午3:30:45
 */
package com.thread;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.thread.daemon.background.DaemonSpawn;

/**
 * @文 件 名: TestThreadArray.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月26日 下午3:30:45
 */
public class TestThreadList {
	
	private List<Thread> ts = new ArrayList<>();
	
	@Before
	public void init() {
		for(int i = 0 ;i<10 ; i ++ ) {
			ts.add(null);
		}
	}
	
	
	@Test
	public void test1() throws Exception {
		for (Thread t : ts) {
			
			t = new Thread(new DaemonSpawn());
		}
		for (Thread t : ts) {
			assertEquals(t, null);
		}
	}
	@Test
	public void test2() throws Exception {
		for(int i = 0 ;i<ts.size();i++) {
			ts.set(i, new Thread( new DaemonSpawn()));
		}
		for(Thread t : ts) {
			assertNotEquals(t, null);
			
		}
		
	}
	
	@Test
	public void test3() throws Exception {
		for (int i = 0; i < ts.size(); i++) {
			Thread tmp = ts.get(0);
			tmp = new Thread(new DaemonSpawn());
			assertNotEquals(tmp, null);
			assertEquals(ts.get(0), null);
		}
		for (Thread t : ts) {
			System.out.println(t);
			assertEquals(t, null);
		}
	}
}
