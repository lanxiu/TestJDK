/*
* @文 件 名:  ExchangeConsumer.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月18日 下午3:42:09 
*/
package com.thread.exchange;

import java.util.List;
import java.util.concurrent.Exchanger;

/**   
 * @文 件 名:  ExchangeConsumer.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月18日 下午3:42:09 
 */
public class ExchangeConsumer<T> implements Runnable{
	
	private Exchanger<List<T>> exchanger;
	private List<T> holder;
	private volatile T value;
	
	
	/**  */
	public ExchangeConsumer(Exchanger<List<T>> ex,List<T> holder) {
		exchanger = ex;
		this.holder = holder;
		
	}
	
	@Override
	public void run() {
		
		try{
			while(Thread.interrupted() == false) {
				System.out.println("consumer before " +holder);
				holder=exchanger.exchange(holder);
				System.out.println("consumer after" +holder);
				for(T x:holder) {
					value =x;
					holder.remove(x);
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("final value: " + value);
	}
	
}
