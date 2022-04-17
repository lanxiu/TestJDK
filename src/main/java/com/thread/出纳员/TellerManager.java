/*
 * @文 件 名: TellerManager.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月31日 下午3:42:14
 */
package com.thread.出纳员;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: TellerManager.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月31日 下午3:42:14
 */
public class TellerManager implements Runnable {
	
	private ExecutorService			exec;
	private CustomerLine			customers;
	private PriorityQueue<Teller>	workingTellers			= new PriorityQueue<>();
	private Queue<Teller>			tellerDoingOtherThings	= new LinkedList<>();
	private int						adjustmentPeriod;
//	private static Random			rand					= new Random(47);
	
	public TellerManager(ExecutorService e, CustomerLine customerLine, int adjustmentPeriod) {
		exec = e;
		this.customers = customerLine;
		this.adjustmentPeriod = adjustmentPeriod;
		Teller teller = new Teller(customers);
		exec.execute(teller);
		workingTellers.add(teller);
	}
	
	public void adjustTellerNumber() {
		if (customers.size() / workingTellers.size() > 2) {
			if (tellerDoingOtherThings.size() > 0) {
				Teller teller = tellerDoingOtherThings.remove();
				teller.serveCustomerLine();
				workingTellers.offer(teller);
				return;
			}
			Teller teller = new Teller(customers);
			exec.execute(teller);
			workingTellers.add(teller);
			return;
		}
		if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2)
			reassignOneTeller();
		if (customers.size() == 0)
			while (workingTellers.size() > 1)
				reassignOneTeller();
	}
	
	private void reassignOneTeller() {
		Teller teller = workingTellers.poll();
		teller.doSomethingElse();
		tellerDoingOtherThings.offer(teller);
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
				adjustTellerNumber();
				System.out.println(customers + " {  ");
				for (Teller teller : workingTellers)
					System.out.println(teller.shortString() + "  ");
				System.out.println(" } ");
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted ");
		}
		System.out.println(this + " terminating ");
	}
	
	@Override
	public String toString() {
		return "TellerManager";
	}
}
