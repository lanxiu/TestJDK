/*
* @文 件 名:  AtomicityTest.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月13日 下午5:20:04 
*/
package com.thread.shareResource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
 * @文 件 名:  AtomicityTest.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月13日 下午5:20:04 
 */
public class AtomicityTest implements Runnable{
	
	private int i = 0;
	
	public int getValue() {
		return i;
	}
	
	private synchronized void evenIncrement() {
		i++;
		i++;
	};
	
	@Override
	public void run() {
		while(true)
			evenIncrement();
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while(true) {
			int val = at.getValue();
			if(val%2!=0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
