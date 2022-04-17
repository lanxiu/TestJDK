 
package com.thread.cyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

 
public class HorseRace {

	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<>();
	private ExecutorService exec = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	private final int pause;
	public HorseRace(int nHorses,final int pause){
		barrier = new CyclicBarrier(nHorses, new BarrierHorse());
		this.pause = pause;
		for(int i = 0; i<nHorses ; i++) {
			Horse horse = new Horse(barrier);
			horses.add(horse);
			exec.execute(horse);
		}
	}
	
	public class BarrierHorse implements Runnable{
		@Override
		public void run() {
			StringBuilder sb  = new StringBuilder();
			for(int i = 0 ; i< FINISH_LINE ; i++)
				sb.append("=");
			System.out.println(sb);
			for(Horse horse:horses)
				System.out.println(horse.tracks());
			for(Horse horse:horses)
				if(horse.getStrides() >= FINISH_LINE) {
					System.out.println(horse + "won !!");
					exec.shutdownNow();
					return;
				}
			try {
				TimeUnit.MILLISECONDS.sleep(pause);
			}
			//TODO:为什么没走到
			catch (InterruptedException e) {
				System.out.println(this + "interrupted ");
			}
		}
	}
	
	
	public static void main(String[] args) {
		int nhorses = 7 ;
		int pause = 200;
		new HorseRace(nhorses,pause);
	}
	
	
	
	
	
}
