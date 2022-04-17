/*
* @文 件 名:  Daemons.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月26日 下午3:04:23 
*/
package com.thread.daemon.background;

import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  Daemons.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  后台线程创建的线程也均为后台线程
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月26日 下午3:04:23 
 */
public class Daemons {
	public static void main(String[] args) throws Exception{
		
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		
		System.out.println( " d is daemon" + d.isDaemon());
		// allow the daemon threads to finish their startup  processes;
		TimeUnit.SECONDS.sleep(1);
		
	}
}
