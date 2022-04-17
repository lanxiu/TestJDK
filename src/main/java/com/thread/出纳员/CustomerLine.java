/*
 * @文 件 名: CustomerLine.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月31日 下午3:00:45
 */
package com.thread.出纳员;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @文 件 名: CustomerLine.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月31日 下午3:00:45
 */
public class CustomerLine extends ArrayBlockingQueue<Customer> {
	
	/** */
	private static final long serialVersionUID = 6870602622653598313L;

	public CustomerLine(int maxLineSize) {
		super(maxLineSize);
	}
	
	@Override
	public String toString() {
		if (this.size() == 0)
			return "[Empty]";
		StringBuilder result = new StringBuilder();
		for (Customer customer : this) {
			result.append(customer);
		}
		return result.toString();
	}
}
