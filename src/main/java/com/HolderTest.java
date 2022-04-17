package com;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class HolderTest {

	static Holder holder;

	@Test
	public void test() {
		
		new Thread(){
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				holder = new Holder(11);
				
			};
			
		}.start();
		
		for(;;)
		new Thread(){
			public void run() {
				try {
				holder = new Holder(new Double(Math.random()).intValue());
				holder.assertSainty();
						}
				catch(Exception e){
					e.printStackTrace();
				}
			};
			
		}.start();
		
	}
}
