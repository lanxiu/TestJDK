/*
* @文 件 名:  SynchronizedEvenGenerator.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月13日 下午3:19:26 
*/
package com.thread.ResourceVisit;


/**   
 * @文 件 名:  SynchronizedEvenGenerator.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月13日 下午3:19:26 
 */
public class SynchronizedEvenGenerator extends EvenGenerator {
	
	public synchronized int next() {
		// 错误直接抛出异常，不便维护状态
		return super.next();
	}
	
	public static void main(String[] args) {
		EvenChecker .test(new SynchronizedEvenGenerator());
	}
}
