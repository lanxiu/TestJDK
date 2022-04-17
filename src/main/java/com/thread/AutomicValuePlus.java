package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AutomicValuePlus extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<100;i++)
			new AutomicValuePlus().start();

	}
    public void synMethod(Integer a1){

        synchronized(a1) {

          //һ��ֻ����һ���߳̽���

        }
        synchronized (this) {

            System.out.println(Thread.currentThread().getName());

          }
      }
	static AtomicInteger value = new AtomicInteger();

	public  void getNext() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(value.getAndIncrement());
	}
	@Override
	public void run() {
		 this.getNext();
	}
}
