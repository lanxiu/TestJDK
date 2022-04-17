package com.thread;

public class UnsafeCachingFactorizer extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<100;i++)
			new UnsafeCachingFactorizer().start();
	}

	static Integer value = 1;
	
	public void getNext() {
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (value) {
			System.out.println(value++);
		}
	}

	@Override
	public void run() {
		 this.getNext();
	}
}
