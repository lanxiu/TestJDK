/*
* @文 件 名:  MutexEvenGenerator.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月13日 下午3:35:37 
*/
package com.thread.ResourceVisit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**   
 * @文 件 名:  MutexEvenGenerator.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月13日 下午3:35:37 
 */
public class MutexEvenGenerator extends EvenGenerator {
	
	private Lock lock = new ReentrantLock();
	
	public int next() {
		lock.lock();
		try {
			return super.next();
		}
		finally {
			// 维护正确的状态
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}
	
}
