/*
 * @文 件 名: GreenhouseScheduler.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月14日 下午7:21:23
 */
package com.thread.温室控制器;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @文 件 名: GreenhouseScheduler.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年5月14日 下午7:21:23
 */
public class GreenhouseScheduler {
	
	private volatile boolean	light		= false;
	private volatile boolean	water		= false;
	private String				thermostat	= "Day";
	
	public synchronized String getThermostat() {
		return thermostat;
	}
	
	public synchronized void setThermostat(String value) {
		thermostat = value;
	}
	
	ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
	
	public void schedule(Runnable event, long delay) {
		scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
	}
	
	public void repeat(Runnable event, long initialDelay, long period) {
		scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
	}
	
	class LightOn implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("turning on lights ");
			light = true;
		}
	}
	
	class LightOff implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("turning off lights ");
			light = false;
		}
	}
	
	class WaterOn implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("turning green house water on  ");
			water = true;
		}
	}
	
	class WaterOff implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("turning green house water off  ");
			water = false;
		}
	}
	
	class ThermodstatNight implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thermostat to night setting");
			setThermostat("Night");
		}
	}
	
	class ThermodstatDay implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Thermostat to day setting");
			setThermostat("Day");
		}
	}
	
	class Bell implements Runnable {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Bing !");
		}
	}
	
	class Terminate implements Runnable {
		
		@Override
		public void run() {
			System.out.println("Terminating");
			scheduler.shutdownNow();
			new Thread() {
				@Override
				public void run() {
					for (DataPoint d : data)
						System.out.println(d);
				}
			}.start();
		}
	}
	
	static class DataPoint {
		
		final Calendar	time;
		final float		temperature;
		final float		humiidity;
		
		public DataPoint(Calendar c, float temp, float hum) {
			this.time = c;
			this.temperature = temp;
			this.humiidity = hum;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return time.getTime() + String.format("temprature : %1$.1f humidity:%2$.2f", temperature, humiidity);
		}
	}
	
	private Calendar lastTime = Calendar.getInstance();
	{
		lastTime.set(Calendar.MINUTE, 30);
		lastTime.set(Calendar.SECOND, 00);
	}
	private float	lastTemp			= 65.0f;
	private int		tempDirection		= +1;
	private float	lastHumidity		= 50.0f;
	private int		humidityDirection	= +1;
	private Random	rand				= new Random(47);
	List<DataPoint>	data				= Collections.synchronizedList(new ArrayList<>());
	
	class CollectData implements Runnable {
		
		@Override
		public void run() {
			System.out.println(" Collecting data");
			synchronized (this) {
				lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
				if (rand.nextInt(5) == 4)
					tempDirection = -tempDirection;
				lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
				if (rand.nextInt(5) == 4)
					humidityDirection = -humidityDirection;
				lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
				data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
			}
		}
	}
	
	public static void main(String[] args) {
		GreenhouseScheduler gh = new GreenhouseScheduler();
		gh.schedule(gh.new Terminate(), 5000);
		gh.repeat(gh.new Bell(), 0, 1000);
		gh.repeat(gh.new ThermodstatNight(), 0, 2000);
		gh.repeat(gh.new LightOn(), 0, 200);
		gh.repeat(gh.new LightOff(), 0, 400);
		gh.repeat(gh.new WaterOn(), 0, 600);
		gh.repeat(gh.new WaterOff(), 0, 800);
		gh.repeat(gh.new ThermodstatDay(), 0, 1400);
		gh.repeat(gh.new CollectData(), 500, 500);
	}
}
