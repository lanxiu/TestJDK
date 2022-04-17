/*
* @文 件 名:  ToastOmatic.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月5日 上午11:01:14 
*/
package com.thread.blokqueue.toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  ToastOmatic.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月5日 上午11:01:14 
 */
public class ToastOmatic {

	public static void main(String[] args) throws Exception {
		ToasterQueue toasterQueue = new ToasterQueue(),
				butterQueue = new ToasterQueue(),
				jammQueue = new ToasterQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(toasterQueue));
		exec.execute(new Butter(toasterQueue, butterQueue));
		exec.execute(new Jamm(butterQueue, jammQueue));
		exec.execute(new Eater(jammQueue));
		System.out.println(" sleep ***************************************");
		TimeUnit.SECONDS.sleep(1);
		System.out.println(" shutdown ***************************************");
		exec.shutdownNow();
		System.out.println(" shutdown ##########################");
	}

}
