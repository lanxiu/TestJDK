/*
* @文 件 名:  SerialNumberChecker.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月14日 上午11:14:08 
*/
package com.thread.shareResource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  SerialNumberChecker.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月14日 上午11:14:08 
 */
public class SerialNumberChecker {
	
	private static final int SIZE =10;
	private static CircularSet serials= new CircularSet(1000);
	
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	static class SerialChecker implements Runnable{

		@Override
		public void run() {
			while(true) {
				int serial = SerialNumberGenerator.nextSerialNumber();
				System.out.println(serial);
				if(serials.contains(serial)) {
					System.out.println("duplicat: " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		for(int i =0; i < SIZE;i++) 
			exec.execute(new SerialChecker());
		if(args.length > 0 ) {
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
			System.out.println("no duplicates detected");
			System.exit(0);
		}
	}
	
}
