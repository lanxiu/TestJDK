/*
* @文 件 名:  Map.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述: TODO(用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年3月6日 上午9:41:41 
*/
package com.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

/**   
 * @文 件 名:  Map.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  TODO
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年3月6日 上午9:41:41 
 */
public class MapTest {

	@Test
	public void mapIterator() {
		Map< String, String> map  = new HashMap<>();
		for(int i =0;i<3;i++)
		map.put(""+i,"1");
		Iterator<Entry<String, String>> it = map.entrySet().iterator();

		System.out.println(map.size());
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
		
		System.out.println(map.size());
		Assert.assertEquals(map.size(), 0);
		
	}
	@Test
	public void mapIteratorKey() {
		Map< String, String> map  = new HashMap<>();
		for(int i =0;i<3;i++)
		map.put(""+i,"1");
		Iterator<String> it = map.keySet().iterator();

		System.out.println(map.size());
		while(it.hasNext()) {
			it.next();
			it.remove();
		}

		Assert.assertEquals(map.size(), 0);
		
	}
	
	
}
