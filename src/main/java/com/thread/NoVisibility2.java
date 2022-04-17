package com.thread;

public class NoVisibility2 {

	   public boolean ready;
	    int number;

	private   class ReadThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (!ready) {
				Thread.yield();
			} 
			System.out.println(number);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {
			NoVisibility2 bb = new NoVisibility2();
			ReadThread aa = bb.new ReadThread();
			aa.start();
			bb.ready = true;
			bb.number = 42;
		}
	}

}
