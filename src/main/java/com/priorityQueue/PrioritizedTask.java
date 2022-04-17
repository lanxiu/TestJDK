/*
 * @文 件 名: DelayedTask.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月10日 下午8:25:51
 */
package com.priorityQueue;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
	private Random random = new Random(47);
	private static int			counter		= 0;
	private final int			id			= counter++;
	private final int			priority;
	private final long			trigger;
	protected static List<PrioritizedTask>	sequence	= new ArrayList<>();
	
	/**  */
	public PrioritizedTask(int priority) {
		this.priority = priority;
		this.trigger = System.nanoTime() + NANOSECONDS.convert(priority, MILLISECONDS);
		this.sequence.add(this);
	}
	
	@Override
	public int compareTo(PrioritizedTask o) {
		
		return priority< o.priority? 1:(priority>o.priority ? -1:0);
		
	}
	
	
	@Override
	public void run() {

		try{
			TimeUnit.SECONDS.sleep(random.nextInt(15));
		} catch (InterruptedException e) {
			System.out.println(" this interrupted ");
		}
		System.out.println(this);
	}
	
	public String toString() {
		return String.format("[%1$-4d]", priority) + " TASK " +id;
	}
	
	public String summary() {
		return "(" + id +":" + priority + ")";
	}
	
	public static class EndSentinel extends PrioritizedTask{
		private ExecutorService exec;
		public EndSentinel( ExecutorService e) {
			super(-1);
			exec =e;
		}
		@Override
		public void run() {
			int count= 0;
			for (PrioritizedTask pt : sequence) {
				System.out.println(pt.summary() + " summary. ");
				if (++count % 5 == 0)
					System.out.println("");
			}
			System.out.println(this + " calling shutdown ");
			exec.shutdownNow();
		}
	}
	
}
