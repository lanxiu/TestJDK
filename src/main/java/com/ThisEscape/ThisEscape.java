package com.ThisEscape;
import java.awt.Event;
import java.awt.event.ActionListener;

public class ThisEscape {

	public ThisEscape(Eventsoure soure) {
		soure.registerListener(new EventListener() {
			public void onEvent(Event e) {
				doSomeThing();
				doEscape();
			}

		});
	}
	
	void doEscape() {}
	
	public class EventListener {
		void doSomeThing() {}
	}
}
