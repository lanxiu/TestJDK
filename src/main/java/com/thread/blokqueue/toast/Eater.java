/*
 * @文 件 名: Toaster.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午10:34:49
 */
package com.thread.blokqueue.toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.thread.blokqueue.toast.Toast.Status;

/**
 * @文 件 名: Toaster.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 上午10:34:49
 */
public class Eater implements Runnable {
	
	private ToasterQueue	jammQueue;
	private int				count	= 0;
	private Random			random	= new Random(47);
	
	public Eater(ToasterQueue jq) {
		this.jammQueue = jq;
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
				Toast t = jammQueue.take();
				if (t.getId() != count++ || t.status != Status.JAMMED)
					System.out.println("error");
				else
					System.out.println("chomp it");
				System.out.println(t);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("eater  interrupted ");
		}
		System.out.println("eater end ");
	}
}
