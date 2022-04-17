/*
* @文 件 名:  ExchangerDemo.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月18日 下午4:18:53 
*/
package com.thread.exchange;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.thread.semaphore.Fat;

/**   
 * @文 件 名:  ExchangerDemo.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月18日 下午4:18:53 
 */
public class ExchangerDemo {
	
	static int size = 10;
	static int delay = 5;
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		Exchanger<List<Fat>> xc = new Exchanger<>();
		List<Fat> producerList = new CopyOnWriteArrayList<>();
		List<Fat> consumerList = new CopyOnWriteArrayList<>();
		exec.execute(new ExchangerProducer<>(xc, BasicGenerator.create(Fat.class), producerList));
		exec.execute(new ExchangeConsumer<>(xc, consumerList));
		
		TimeUnit.SECONDS.sleep(delay);
		exec.shutdown();
		
	}
	
}
