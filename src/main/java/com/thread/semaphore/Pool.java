/*
* @文 件 名:  Pool.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月15日 下午2:48:58 
*/
package com.thread.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**   
 * @文 件 名:  Pool.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月15日 下午2:48:58 
 */
public class Pool<T> {
	
	private int size;
	private List<T> items = new ArrayList<>();
	private volatile boolean[] checkedOut;
	private Semaphore availabel;
	
	
	/**  */
	public Pool(Class<T> classObject,int size) {
		this.size = size;
		this.checkedOut = new boolean[size];
		this.availabel = new Semaphore(size,true);
		for(int i=0;i<size;++i) {
			try {
				items.add(classObject.newInstance());
			} catch (Exception e) {
				throw new RuntimeException(e);
				// TODO: handle exception
			}
		}
	}
	
	public T checkOut() throws InterruptedException{
		availabel.acquire();
		return getItem();
	}
	
	public void checkIn(T x) {
		if(releaseItem(x))
			availabel.release();
		
	}
	private synchronized T getItem() {
		for(int i=0;i<size;i++) 
			if(!checkedOut[i]) {
				checkedOut[i] = true;
				return items.get(i);
			}
		return null ;
	}
	
	private synchronized boolean releaseItem(T item) {
		int index = items.indexOf(item);
		if(index == -1) return false;
		if(checkedOut[index]) {
			checkedOut[index] =false;
			return true;
		}
		return false;
	}
	
}
