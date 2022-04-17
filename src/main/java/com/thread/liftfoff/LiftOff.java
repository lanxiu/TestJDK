/*
* @文 件 名:  LiftOff.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月24日 上午9:34:35 
*/
package com.thread.liftfoff;


/**   
 * @文 件 名:  LiftOff.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月24日 上午9:34:35 
 */
public class LiftOff implements Runnable {
	public static int taskCount = 1;
	protected int		countDown	= 10;
	private final int	id			= taskCount++;
	
	
	/**  */
	public LiftOff() {
		// TODO Auto-generated constructor stub
	}
	
	public LiftOff(int count) {
		this.countDown = count;
	}
	
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Lift off !") + ").";
	}
	
	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}
	}
}
