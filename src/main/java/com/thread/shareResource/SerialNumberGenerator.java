/*
* @文 件 名:  SerialNumberGenerator.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月14日 下午2:39:05 
*/
package com.thread.shareResource;


/**   
 * @文 件 名:  SerialNumberGenerator.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月14日 下午2:39:05 
 */
public class SerialNumberGenerator {

	private static volatile int serialNumber = 0;
	public static int nextSerialNumber() {
		return serialNumber ++ ;
	}

}
