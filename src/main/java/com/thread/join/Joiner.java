/*
* @文 件 名:  Joiner.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月2日 上午10:15:58 
*/
package com.thread.join;


/**   
 * @文 件 名:  Joiner.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月2日 上午10:15:58 
 */
public class Joiner  extends Thread{

	private Sleeper sleeper;
	
	/**
	 * 
	 */
	public Joiner(String name,Sleeper  sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try{
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("interruptedexception");
		}
		System.out.println(getName() + " join completed ");
	}

}
