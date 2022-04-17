/*
* @文 件 名:  EvenGenerator.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月13日 上午10:02:07 
*/
package com.thread.ResourceVisit;


/**   
 * @文 件 名:  EvenGenerator.java 
 * @版     权:  南京集		群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月13日 上午10:02:07 
 */
public class EvenGenerator extends IntGenerator {
	
	private int currentValue = 0;

	/* (non-Javadoc)
	 * @see com.thread.ResourceVisit.IntGenerator#next()
	 */
	@Override
	public int next() {

		++currentValue;
		Thread.yield();
		++currentValue;
		
		return currentValue;
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
