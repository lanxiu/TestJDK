/*
* @文 件 名:  Joining.java 
* @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月2日 上午10:30:48 
*/
package com.thread.join;


/**   
 * @文 件 名:  Joining.java 
 * @版     权:  南京集群软件技术有限公司. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月2日 上午10:30:48 
 */
public class Joining {
	public static void main(String[] args) {
		Sleeper sleepy = new Sleeper("sleepy", 1500),
				grumpy = new Sleeper("grumpy", 1500);
		
		Joiner dopey = new Joiner("Dopey", sleepy),
				doc = new Joiner("Doc", grumpy);
		grumpy.interrupt();
	}
}
