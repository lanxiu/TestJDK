/*
 * @文 件 名: DelayedTask.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月10日 下午8:25:51
 */
package com.delayedQueue;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: DelayedTask.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月10日 下午8:25:51
 */
public class DelayedTask implements Runnable, Delayed {
	
	private static int			counter		= 0;
	private final int			id			= counter++;
	private final int			delta;
	private final long			trigger;
	protected  static List<DelayedTask>	sequence	= new ArrayList<>();
	
	/**  */
	public DelayedTask(int delayInMilliSeconds) {
		this.delta = delayInMilliSeconds;
		this.trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
		this.sequence.add(this);
	}
	
	@Override
	public int compareTo(Delayed o) {
		DelayedTask that = (DelayedTask)o;
		if(trigger<that.trigger) return -1;
		if(trigger > that.trigger) return 1;
		return 0;
	}
	
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(trigger - System.nanoTime()	, NANOSECONDS);
	}
	
	@Override
	public void run() {
		System.out.println(this);
		
	}
	
	public String toString() {
		return String.format("[%1$-4d]", delta) + " TASK " +id;
	}
	
	public String summary() {
		return "(" + id +":" + delta + ")";
	}
	
	public static class EndSentinel extends DelayedTask{
		private ExecutorService exec;
		public EndSentinel(int delay ,ExecutorService e) {
			super(delay);
			exec =e;
		}
		@Override
		public void run() {
			for(DelayedTask pt : sequence) 
				System.out.println(pt.summary() + " summary. ");
			System.out.println(this + " calling shutdown ");
			exec.shutdownNow();
		}
	}
	
}
