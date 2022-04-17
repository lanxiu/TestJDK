/*
 * @文 件 名: PipedIO.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 下午3:17:25
 */
package com.thread.blokqueue.sendReceive;

import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: PipedIO.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 下午3:17:25
 */
public class PipedIO {
	
	public static void main(String[] args) throws Exception {
		PipedWriter pw = new PipedWriter();
		Sender sender = new Sender(pw);
		Receiver receiver = new Receiver(sender);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(3);
		exec.shutdownNow();
	}
}
