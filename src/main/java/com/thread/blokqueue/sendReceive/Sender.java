/*
 * @文 件 名: Sender.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 下午3:08:04
 */
package com.thread.blokqueue.sendReceive;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @文 件 名: Sender.java
 * @版 权: 南京集群软件技术有限公司. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月5日 下午3:08:04
 */
public class Sender implements Runnable {
	
	private PipedWriter pw;
	
	/**  */
	public Sender(PipedWriter pw) {
		this.pw = pw;
	}
	
	public PipedWriter getPipeWriter(){
		return this.pw;
	}
	
	@Override
	public void run() {
		try {
			for (char c = 'A'; c < 'Z'; c++) {
				pw.write(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
