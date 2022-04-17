/*
* @文 件 名:  JavaVMStackSOF.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年9月30日 下午3:25:09 
*/
package jvm;


/**   
 * @文 件 名:  JavaVMStackSOF.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年9月30日 下午3:25:09 
 */
public class JavaVMStackSOF {
	
	private int stackLength = 1;
	public void stackLeak() {
		stackLength ++;
		stackLeak();
	}
	
	/**
	 	-Xms20m -Xmx20m -Xss1m -XX:+HeapDumpOnOutOfMemoryError
	 * */
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} finally{
			System.out.println(oom.stackLength);
		}
	}
	
}
