package com.thread.exchange;

import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerProducer<T> implements Runnable {
	
	private Generator<T>		generator;
	private Exchanger<List<T>>	exchanger;
	private List<T>				holder;
	
	/**  */
	public ExchangerProducer(Exchanger<List<T>> exchg, Generator<T> gen, List<T> holder) {
		exchanger = exchg;
		generator = gen;
		this.holder = holder;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				for (int i = 0; i < ExchangerDemo.size; i++)
					holder.add(generator.next());
				System.out.println("producer " +holder.get(0));
				System.out.println("producer before: " +holder);
				holder = exchanger.exchange(holder);
				System.out.println("producer after: " +holder);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
