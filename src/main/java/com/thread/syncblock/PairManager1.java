/*
* @文 件 名:  PairManager1.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月16日 上午9:07:41 
*/
package com.thread.syncblock;


/**   
 * @文 件 名:  PairManager1.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月16日 上午9:07:41 
 */
public class PairManager1 extends PairManager{
	
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
	
}
