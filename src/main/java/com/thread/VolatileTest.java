package com.thread;

public class VolatileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	volatile boolean assleep;
	
	void threadAssleep() {
		while(!assleep)
			countSomeSheep();
	}

	private void countSomeSheep() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
