 
package com.thread.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

 
public class Horse implements Runnable {
	
	private static int				counter	= 0;
	private final int				id		= counter++;
	private int						strides;
	private static Random			rand	= new Random(47);
	private static CyclicBarrier	barrier;
	
	public Horse(CyclicBarrier b) {
		barrier = b;
	}
	
	public synchronized int getStrides() {
		return strides;
	}
	
	@Override
	public void run() {
		try {
			while (Thread.interrupted() == false) {
				synchronized (this) {
					strides += rand.nextInt(3);
				}
				barrier.await();
			}
		} catch (InterruptedException e) {
			System.out.println(this + "interrupted");
		} catch (BrokenBarrierException e) {
			System.out.println(this + " broken barrier");
		}
	}
	
	@Override
	public String toString() {
		return "horse " + id;
	}
	
	public String tracks() {
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i< getStrides(); i++) {
			sb.append("*");
		}
		sb.append(id);
		return sb.toString();
	}
	
	
	
}
