/*
 * @文 件 名: Pair.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年3月15日 下午8:48:40
 */
package com.thread.syncblock;

/**
 * @文 件 名: Pair.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年3月15日 下午8:48:40
 */
public class Pair {
	
	private int x, y;
	
	/**
	 * 
	 */
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 */
	public Pair() {
		this(0, 00);
	}
	
	public int getX() {
		return x;
	};
	
	public int getY() {
		return y;
	};
	
	public void incrementX() {
		x++;
	}
	
	public void incrementY() {
		y++;
	}
	
	public String toString() {
		return "x: " + x + " ，y : " + y;
	}
	
	public class PairValuesNotEqualException extends RuntimeException {
		
		public PairValuesNotEqualException() {
			super("pair values not equal :" + Pair.this);
		}
	}
	
	public void checkState() {
		if (x != y)
			throw new PairValuesNotEqualException();
	}
}
