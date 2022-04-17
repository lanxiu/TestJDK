/*
* @文 件 名:  TaskWithResult.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年2月24日 上午9:12:40 
*/
package com.thread.callable;

import java.util.concurrent.Callable;

/**   
 * @文 件 名:  TaskWithResult.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年2月24日 上午9:12:40 
 */
public class TaskWithResult implements Callable<String>{
	
	private int id;
	
	public TaskWithResult(int id ) {
		this.id = id;
	}
	
	public String call () {
		return "result of TaskWithResult  " + id;
	}
}
