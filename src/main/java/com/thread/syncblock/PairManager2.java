/*
* @文 件 名:  PairManager2.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月16日 上午9:13:39 
*/
package com.thread.syncblock;


/**   
 * @文 件 名:  PairManager2.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月16日 上午9:13:39 
 */
public class PairManager2  extends PairManager{
	
	public void increment() {
		
		Pair temp;
		
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		
		store(temp);
	}

}
