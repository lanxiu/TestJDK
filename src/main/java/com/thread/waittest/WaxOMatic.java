/*
* @文 件 名:  WaxOMatic.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月4日 下午7:45:09 
*/
package com.thread.waittest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  WaxOMatic.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月4日 下午7:45:09 
 */
public class WaxOMatic {
	public static void main(String[] args) throws Exception {
		
		Car car = new Car();
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new WaxOn(car));
		es.execute(new WaxOff(car));
		TimeUnit.SECONDS.sleep(1);
		es.shutdownNow();
	}
}
