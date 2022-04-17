/*
* @文 件 名:  IntGenerator.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月10日 下午2:41:31 
*/
package com.thread.ResourceVisit;


/**   
 * @文 件 名:  IntGenerator.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月10日 下午2:41:31 
 */
public abstract class IntGenerator {
	
	private volatile boolean canceled = false;
	
	public abstract int next();
	
	public void cancel() {
		canceled = true;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
	
}
