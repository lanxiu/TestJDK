/*
* @文 件 名:  PairChecker.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月16日 上午9:38:35 
*/
package com.thread.syncblock;


/**   
 * @文 件 名:  PairChecker.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月16日 上午9:38:35 
 */
public class PairChecker  implements Runnable{
	
	private PairManager pm;
	
	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		while(true) {
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
	
}
