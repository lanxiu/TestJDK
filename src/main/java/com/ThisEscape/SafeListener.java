package com.ThisEscape;

import java.math.BigInteger;

public class SafeListener {

	private final EventListener listener;
	

	
	
	private SafeListener(){
		listener = new EventListener(){
			void onEvent() {
				
			}
		};
	}
	public static  SafeListener newInstance(Eventsoure source){
		SafeListener sl = new SafeListener();
		source.registerListener(sl.listener);
		return sl;
	}
	class EventListener{
		
	}
	
}
