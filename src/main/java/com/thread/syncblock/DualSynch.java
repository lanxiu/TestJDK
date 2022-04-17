/*
* @文 件 名:  DualSynch.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月16日 下午8:26:56 
*/
package com.thread.syncblock;


/**   
 * @文 件 名:  DualSynch.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月16日 下午8:26:56 
 */
public class DualSynch {
	
	private Object syncObject = new Object();
	public synchronized void f() {
		for(int i = 0 ; i < 5; i++) {
			System.out.println(" f ( ) ");
			Thread.yield();
		}
	}
	
	public void g() {
		synchronized (syncObject) {
			for(int i = 0; i < 5 ; i++) {
				System.out.println(" g() ");
				Thread.yield();
			}
			
		}
	}
	
}
