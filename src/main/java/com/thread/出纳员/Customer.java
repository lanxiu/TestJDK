/*
 * @文 件 名: Customer.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月31日 下午2:57:27
 */
package com.thread.出纳员;

/**
 * @文 件 名: Customer.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月31日 下午2:57:27
 */
public class Customer {
	
	private final int serviceTime;
	
	public Customer(int tm) {
		this.serviceTime = tm;
	}
	
	public int getServiceTime() {
		return serviceTime;
	}
	
	@Override
	public String toString() {
		return "[" + serviceTime + "]";
	}
}
