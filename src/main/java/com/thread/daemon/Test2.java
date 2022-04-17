/*
* @文 件 名:  Test1.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2019年5月27日 下午3:58:55 
*/
package com.thread.daemon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**   
 * @文 件 名:  Test1.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2019年5月27日 下午3:58:55 
 */
public class Test2 extends Thread
{
	private int j =3;
	
	public Test2(int i){
		this.j = i;
	}
	
	@Override
	public void run()
	{
		
			try
			{
				while (true)
				{
					Thread.sleep(10);
					int a= 11;
				}
			}
			catch ( Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println(j + "--- me alive");
		
	}

	public static void main(String[] args) throws InterruptedException
	{
		BlockingQueue<Runnable> workQueue = new  ArrayBlockingQueue<>(2);
//		workQueue.add(new Test2());
		ThreadPoolExecutor es = new ThreadPoolExecutor(2, 3, 1, TimeUnit.SECONDS	,workQueue);
		
			es.execute(new Test2(1));
			
			es.shutdownNow();
			
			Thread.sleep(100);
			
			es.execute(new Test2(2));
		
		
		Thread.sleep(100);
		System.out.println("Main End");
	}
}