/*
* @文 件 名:  Toast.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月5日 上午10:13:56 
*/
package com.thread.blokqueue.toast;


/**   
 * @文 件 名:  Toast.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月5日 上午10:13:56 
 */
public class Toast {
	
	public enum Status{DRY,BUTTERED,JAMMED};
	
	public Status status = Status.DRY;
	
	private final int id ;
	

	public Toast(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void butter() {
		this.status = Status.BUTTERED;
	}public void jamm() {
		this.status = Status.JAMMED;
	}
	public String toString() {
		
		
		return  this.id + "status : " + this.status;
	}
	
	
}
