/*
* @文 件 名:  Sleeper.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月2日 上午9:34:01 
*/
package com.thread.join;


/**   
 * @文 件 名:  Sleeper.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月2日 上午9:34:01 
 */
public class Sleeper extends Thread {
	
	private int duration;
	
	public Sleeper (String name,int sleepTime) {
		super(name);
		duration = sleepTime;
		start();
	}

	@Override
	public void run() {
		try{
			sleep(duration);
		} catch (InterruptedException e) {
			// 异常处理会清除中断标志，因此中断标志位false
			System.out.println(getName() + " was interrupted" + "is Interrunpted() " + isInterrupted());
		}
		System.out.println(getName() + " has awakened");
		super.run();
	}

}
