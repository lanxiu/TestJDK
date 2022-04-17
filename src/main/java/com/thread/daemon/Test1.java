/*
* @文 件 名:  Test1.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2019年5月27日 下午3:58:55 
*/
package com.thread.daemon;


/**   
 * @文 件 名:  Test1.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2019年5月27日 下午3:58:55 
 */
public class Test1 extends Thread
{
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("我还活着");
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		Thread t = new Test1();
		t.start();
		Thread.sleep(5000);
		System.out.println("Main End");
	}
}