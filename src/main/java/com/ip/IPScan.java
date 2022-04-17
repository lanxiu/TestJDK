/*
 * @文 件 名: IPScan.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: TODO(用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年1月3日 下午4:45:30
 */
package com.ip;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @文 件 名: IPScan.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: TODO
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年1月3日 下午4:45:30
 */
public class IPScan {
	
	static public HashMap ping; // ping 后的结果集
	
	public HashMap getPing() { // 用来得到ping后的结果集
		return ping;
	}
	
	// 当前线程的数量, 防止过多线程摧毁电脑
	static int threadCount = 0;
	
	public IPScan() {
		ping = new HashMap();
	}
	
	public void Ping(String ip) throws Exception {
		// 最多30个线程
		while (threadCount > 30)
			Thread.sleep(50);
		threadCount += 1;
		PingIp p = new PingIp(ip);
		p.start();
	}
	
	public void PingAll() throws Exception {
		// 首先得到本机的IP，得到网段
		InetAddress host = InetAddress.getLocalHost();
		String hostAddress = host.getHostAddress();
		int k = 0;
		k = hostAddress.lastIndexOf(".");
		String ss ="10.42.205.";
		for (int i = 1; i <= 255; i++) { // 对所有局域网Ip
			String iip = ss + i;
			Ping(iip);
		}
		// 等着所有Ping结束
		while (threadCount > 0)
			Thread.sleep(50);
	}
	
	public static void main(String[] args) throws Exception {
		IPScan ip = new IPScan();
		ip.PingAll();
		java.util.Set entries = ping.entrySet();
		Iterator iter = entries.iterator();
		String k;
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			if (value.equals("false"))
				System.out.println(key );
		}
	}
	
	class PingIp extends Thread {
		
		public String ip; // IP
		
		public PingIp(String ip) {
			this.ip = ip;
		}
		
		public void run() {
			try {
				Process p = Runtime.getRuntime().exec("ping " + ip + " -w 300 -n 1");
				InputStreamReader ir = new InputStreamReader(p.getInputStream(),"gbk");
				LineNumberReader input = new LineNumberReader(ir);
				// 读取结果行
				for (int i = 0; i <2; i++) {

					String s = input.readLine();
				}
				String line = input.readLine();
				if (line  == null || line.contains("超时"))
					ping.put(ip, "false");
				else
					ping.put(ip, "true");
				// 线程结束
				threadCount -= 1;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
