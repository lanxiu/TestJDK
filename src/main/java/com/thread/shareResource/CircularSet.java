/*
* @文 件 名:  CircularSet.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月14日 上午9:33:54 
*/
package com.thread.shareResource;

/**   
 * @文 件 名:  CircularSet.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月14日 上午9:33:54 
 */
public class CircularSet {

	private int[] array;

	private int len;
	private int index =0;
	
	public CircularSet(int size) {
		array = new int[size];
		len = size;
		for(int i = 0;i<size;i++)
			array[i] = -1;
	}
	
	public synchronized void add(int i ) {
		array[index] = 1;
		index = ++index % len;
	}

	public synchronized boolean contains(int val) {
		for(int i=0;i<len;i++)
			if(array[i] == val)
				return true;
		return false;
	}
	
}
