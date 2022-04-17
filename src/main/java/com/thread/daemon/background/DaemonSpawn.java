/*
* @文 件 名:  DaemonSpawn.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月26日 下午2:54:58 
*/
package com.thread.daemon.background;


/**   
 * @文 件 名:  DaemonSpawn.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月26日 下午2:54:58 
 */
public class DaemonSpawn implements Runnable {
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while(true) 
			Thread.yield();
	}
	
}
