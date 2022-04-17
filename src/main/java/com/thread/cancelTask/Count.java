/*
* @文 件 名:  Count.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月24日 下午3:47:17 
*/
package com.thread.cancelTask;

import java.util.Random;

/**   
 * @文 件 名:  Count.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月24日 下午3:47:17 
 */
public class Count {
	
	private int count = 0;
	private Random rand = new Random(47);
	// remove the synchronied keyword to see counting fail:
	public synchronized int increment() {
		int temp = count;
		if(rand.nextBoolean())
			Thread.yield();
		return (count = ++ temp);
		
	}
	public synchronized int value() {
		return count;
	}
}
