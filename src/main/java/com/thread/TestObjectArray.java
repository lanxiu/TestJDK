/*
* @文 件 名:  TestObjectArray.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月26日 下午3:30:45 
*/
package com.thread;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**   
 * @文 件 名:  TestObjectArray.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月26日 下午3:30:45 
 */
public class TestObjectArray {
	
	private Object[] ts = new Object[10];

	@Test
	public void test1() throws Exception {
		for(Object t : ts) {
			t = new Object();
		}
		for(Object t : ts) {
			System.out.println(t);
			assertEquals(t, null);
			
		}
		
	}
	@Test
	public void test2() throws Exception {
		for(int i = 0 ;i<ts.length;i++) {
			ts[i] = new Object();
		}
		for(Object t : ts) {
			System.out.println(t);
			assertNotEquals(t, null);
			
		}
		
	}
	@Test
	public void test3() throws Exception {
		for(int i = 0 ;i<ts.length;i++) {
			Object tmp = ts[i];
			tmp = new Object();
			assertNotEquals(tmp, null);
			assertEquals(ts[i], null);
		}
		for(Object t : ts) {
			System.out.println(t);
			assertEquals(t, null);
			
		}
		
	}
	
 public static void main(String[] args) {
	  Object[] ts2 = new Object[10];
	for(int i = 0 ;i<ts2.length;i++) {
		Object tmp = ts2[i];
		tmp = new Object();
		System.out.println(ts2[i]);
	}
	

	  String[] ts3 = new String[10];
	  

		for(String tmp:ts3) {
			tmp = "111";
			System.out.println(tmp);
		}
	  
	for(int i = 0 ;i<ts3.length;i++) {
		Object tmp = ts3[i];
		tmp = "1111";
		System.out.println(ts3[i]);
	}

	
	List<String> lst =new ArrayList<>();
	for(int i = 0 ;i<lst.size();i++) {
		Object tmp = lst.get(0);
		tmp = "1111";
		System.out.println(ts3[i]);
	}
	
}
	
}
