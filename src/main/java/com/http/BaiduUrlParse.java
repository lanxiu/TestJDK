/*
* @文 件 名:  BaiduUrlParse.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年8月6日 下午7:48:09 
*/
package com.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**   
 * @文 件 名:  BaiduUrlParse.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年8月6日 下午7:48:09 
 */
public class BaiduUrlParse {
	
	/**   
	 * 功能简述:  
	 * @author  0216000799
	 * @version  1.0
	 * @since 1.0
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "https://www.baidu.com/link?url=OtoY9YiEMfNlM8VWsB3gAOgdM24N9kx5Jt7rnuE9DpPzBF88BF1JhTaO22AJFKwxHdMaPicSr3ff_ocnIeLs7a&wd=&eqid=be1928f200058676000000055b6833d7";
	
		try {
			URL url = new URL(str);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			conn.getResponseCode();
			String realUrl=conn.getURL().toString();
			conn.disconnect();
			System.out.println("真实URL:"+realUrl);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		
	}
}
