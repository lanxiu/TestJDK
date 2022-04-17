/*
* @文 件 名:  Receiver.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月5日 下午3:10:11 
*/
package com.thread.blokqueue.sendReceive;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**   
 * @文 件 名:  Receiver.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月5日 下午3:10:11 
 */
public class Receiver implements Runnable{
	
	private PipedReader pr;
	
	/**  */
	public Receiver(Sender sender) throws IOException{
	pr = new PipedReader(sender.getPipeWriter());
	}
	
	@Override
	public void run() {

		try {
			while(true) {
				System.out.println((char)pr.read());
			}
		} catch (IOException e) {
			System.out.println(" receive error ");
		}
		
		
	}
	
}
