/*
* @文 件 名:  RestaurantWithQueues.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月23日 上午10:53:07 
*/
package com.thread.饭店仿真;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
 * @文 件 名:  RestaurantWithQueues.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月23日 上午10:53:07 
 */
public class RestaurantWithQueues {
	
	public static void main(String[] args) throws Exception{
		
		ExecutorService exec = Executors.newCachedThreadPool();
		Restaurant restaurant = new Restaurant(exec, 5, 2);
		exec.execute(restaurant);
		System.out.println("press enter to quit");
		System.in.read();
		exec.shutdownNow();
		
	}
}
