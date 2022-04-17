/*
 * @文 件 名: VectorOpre.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2017年11月21日 上午9:17:01
 */
package com.vector;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: VectorOpre.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2017年11月21日 上午9:17:01
 */
public class VectorOpre {
	
	public static void main(String[] args) {
		VectorOpre vo = new VectorOpre();
		vo.delete();
	}
	
	//TODO: 线程池使用为何只调用了一次
	private void delete() {
		ArrayBlockingQueue<Runnable> abq = new ArrayBlockingQueue<>(3);
		abq.add(new operaDelete());
		abq.add(new operaDelete());
		abq.add(new operaGet());
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,abq);
		tpe.execute(new operaDelete());
		tpe.shutdown();
		for(;;) {
		new operaDelete().start();
		}
//		System.out.println(VectorNotSafe.vNotSafe.size());
	}
	
	public class operaDelete extends Thread {
		
		public void run() {
			VectorNotSafe.deleteLast();
		}
	}
	
	public class operaGet extends Thread {
		
		public void run() {
			VectorNotSafe.getLast();
		}
	}
}
