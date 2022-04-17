/*
* @文 件 名:  BankTellerSimulation.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月31日 下午4:11:44 
*/
package com.thread.出纳员;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
 * @文 件 名:  BankTellerSimulation.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月31日 下午4:11:44 
 */
public class BankTellerSimulation {
	static final int MAX_LINE_SIZE =50;
	static final int ADJUSTMENT_PERIOD = 1000;
	
	public static void main(String[] args) throws Exception {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
		exec.execute(new CustomerGenerator(customers));
		exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));
		System.out.println(" press enter to quit");
		System.in.read();
		exec.shutdownNow();
	}
}
