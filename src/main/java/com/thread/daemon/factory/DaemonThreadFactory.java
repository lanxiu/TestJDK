/*
* @文 件 名:  DaemonThreadFactory.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月24日 下午2:53:53 
*/
package com.thread.daemon.factory;

import java.util.concurrent.ThreadFactory;

/**   
 * @文 件 名:  DaemonThreadFactory.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月24日 下午2:53:53 
 */
public class DaemonThreadFactory implements ThreadFactory {
	
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}
	
	
	
}
