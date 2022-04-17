/*
* @文 件 名:  Car.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月29日 下午4:18:47 
*/
package com.thread.汽车组装;


/**   
 * @文 件 名:  Car.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月29日 下午4:18:47 
 */
public class Car {
	
	public final int id;
	private boolean engine = false, driverTrain = false,wheels = false;
	
	public Car(int idn) {
		id =idn;
	}
	public Car() {
		id = -1;
	}
	public synchronized int getId() {
		return id;
	}
	
	public synchronized void addEngine() {
		engine = true;
	}
	public synchronized void addDriverTrain() {
		driverTrain = true;
	}
	public synchronized void addWheels() {
		wheels = true;
	}
	
	
	
	
	
}
