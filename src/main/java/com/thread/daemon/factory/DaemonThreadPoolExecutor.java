/*
 * @文 件 名: DaemonThreadPoolExecutor.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月24日 下午3:23:12
 */
package com.thread.daemon.factory;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: DaemonThreadPoolExecutor.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年2月24日 下午3:23:12
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
	
	public DaemonThreadPoolExecutor() {
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
	}
}
