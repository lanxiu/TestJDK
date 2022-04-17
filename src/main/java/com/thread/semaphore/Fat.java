/*
* @文 件 名:  Fat.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月15日 下午7:12:18 
*/
package com.thread.semaphore;


/**   
 * @文 件 名:  Fat.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月15日 下午7:12:18 
 */
public class Fat {
	
	private volatile double d;
	private static int counter = 0;
	private final int id = counter++;
	public Fat() {
		for(int i = 1;i<10000;i++)
			d+=(Math.PI+Math.E)/(double)i;
	}
	public void operation() {
		System.out.println(this);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FAT id: " + id;
	}
	
}
