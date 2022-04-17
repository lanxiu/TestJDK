/*
* @文 件 名:  BasicGenerator.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年5月18日 下午4:24:40 
*/
package com.thread.exchange;


/**   
 * @文 件 名:  BasicGenerator.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年5月18日 下午4:24:40 
 */
public class BasicGenerator<T>implements Generator<T> {
	
	private Class<T> type;
	public BasicGenerator(Class<T> type) {
		this.type = type;
	}
	
	public T next() {
		try{
			return type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
			return null;
		}
	}
	
	public static <T> Generator<T> create (Class<T> type) {
		return new BasicGenerator<T>(type);
	}
}
