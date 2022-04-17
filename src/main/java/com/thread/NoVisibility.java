package com.thread;

public class NoVisibility {

	private static boolean ready;
	private static int number;

	private static class ReadThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (!ready) {
				Thread.yield();
			}
			if(number ==0)
			System.out.println(number);
			number= 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			new ReadThread().start();
			number = 42;
			ready = true;
		}
	}

}
