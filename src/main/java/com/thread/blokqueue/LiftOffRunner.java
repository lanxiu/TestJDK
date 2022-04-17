/*
* @文 件 名:  LiftOffRunner.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月5日 上午9:37:14 
*/
package com.thread.blokqueue;

import java.util.concurrent.BlockingQueue;

import com.thread.liftfoff.LiftOff;

/**   
 * @文 件 名:  LiftOffRunner.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月5日 上午9:37:14 
 */
public class LiftOffRunner implements Runnable{

	private BlockingQueue< LiftOff> rockets;
	public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
		this.rockets  = rockets;
	}

	public void add(LiftOff lo) {
		try {
		rockets.put(lo);
		}catch (InterruptedException e) {
			System.out.println(" put interrupted !!!");
		}
	}

	@Override
	public void run() {
		try{
			while (Thread.interrupted() == false) {
				LiftOff lo = rockets.take();
				lo.run();
			}
		} catch (InterruptedException e) {
			System.out.println(" waiting from take. ");
		}
		System.out.println( " existing liftoffrunner " );
	}

}
