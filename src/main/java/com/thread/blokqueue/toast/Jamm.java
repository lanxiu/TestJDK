/*
 * @文 件 名: Butter.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午10:33:32
 */
package com.thread.blokqueue.toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: Butter.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午10:33:32
 */
public class Jamm implements Runnable {
	
	private ToasterQueue	butterQueue, JammQueue;
	private int				count	= 0;
	private Random			random	= new Random(47);
	
	public Jamm(ToasterQueue bq, ToasterQueue jq) {
		this.JammQueue = jq;
		this.butterQueue = bq;
	}
	
	/**
	 * 功能简述:
	 * 
	 * @author 0216000799
	 * @version 1.0
	 * @since 1.0
	 */
	public void run() {
		try {
			while (Thread.interrupted() == false) {
				Toast t = butterQueue.take();
				t.jamm();
				System.out.println(t);
				JammQueue.put(t);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("jamm interrupted ");
		}
		System.out.println("jamm end ");
	}
}
