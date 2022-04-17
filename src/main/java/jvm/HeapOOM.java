/*
* @文 件 名:  HeapOOM.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年9月30日 下午2:53:42 
*/
package jvm;

import java.util.ArrayList;
import java.util.List;

//import java.util.List;

/**   
 * @文 件 名:  HeapOOM.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  测试OOM
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年9月30日 下午2:53:42 
 */
public class HeapOOM {
	
	static class OOMObject{}
	/**
 
 	-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 
 
	 */
	public static void main(String[] args) {
		List<OOMObject> lst = new ArrayList<>();
		while(true) {
			lst.add(new OOMObject());
		}
	}
	
	
}
