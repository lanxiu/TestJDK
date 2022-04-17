/*
* @文 件 名:  TestThreadArray.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月26日 下午3:30:45 
*/
package com.thread;

import static org.junit.Assert.*;

import org.junit.Test;

import com.thread.daemon.background.DaemonSpawn;

/**   
 * @文 件 名:  TestThreadArray.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月26日 下午3:30:45 
 */
public class TestThreadArray {
	
	private Thread[] ts = new Thread[10];

	@Test
	public void test1() throws Exception {
		for(Thread t : ts) {
			t = new Thread( new DaemonSpawn());
		}
		for(Thread t : ts) {
			System.out.println(t);
			assertEquals(t, null);
			
		}
		
	}
	@Test
	public void test2() throws Exception {
		for(int i = 0 ;i<ts.length;i++) {
			ts[i] = new Thread( new DaemonSpawn());
		}
		for(Thread t : ts) {
			System.out.println(t);
			assertNotEquals(t, null);
			
		}
		
	}
	@Test
	public void test3() throws Exception {
		for(int i = 0 ;i<ts.length;i++) {
			Thread tmp = ts[i];
			tmp = new Thread( new DaemonSpawn());
			assertNotEquals(tmp, null);
			assertEquals(ts[i], null);
		}
		for(Thread t : ts) {
			System.out.println(t);
			assertEquals(t, null);
			
		}
		
	}
	
 
	
}
