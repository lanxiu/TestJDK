/*
* @文 件 名:  RuntimeConstantPoolOOM.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年9月30日 下午3:34:27 
*/
package jvm;

import java.util.ArrayList;
import java.util.List;

/**   
 * @文 件 名:  RuntimeConstantPoolOOM.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年9月30日 下午3:34:27 
 */
public class RuntimeConstantPoolOOM {
	/**
	-Xms20m -Xmx20m -Xss3m  -XX:MaxPermSize=10M  -XX:+HeapDumpOnOutOfMemoryError
	*/
	public static void main(String[] args) {
		
		
		List<String> lst = new ArrayList<>();
		int i=0;
		while(  true) {
			lst.add(String.valueOf(i++).intern());
		}
		
		
	}
}
