/*
* @文 件 名:  AtomicEvenGenerator.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月14日 下午4:30:57 
*/
package com.thread.ResourceVisit;

import java.util.concurrent.atomic.AtomicInteger;

/**   
 * @文 件 名:  AtomicEvenGenerator.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月14日 下午4:30:57 
 */
public class AtomicEvenGenerator  extends IntGenerator{
	
	private AtomicInteger currentValue = new AtomicInteger(0);

	public int next() {
		return currentValue.addAndGet(2);
	}

	public static void main(String[] args) {
		EvenChecker.test(new AtomicEvenGenerator());
	}
	
}
