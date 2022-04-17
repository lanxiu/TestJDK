/*
* @文 件 名:  Enums.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年6月9日 下午4:20:02 
*/
package com.thread.饭店仿真;

import java.util.Random;

/**   
 * @文 件 名:  Enums.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年6月9日 下午4:20:02 
 */
public class Enums {
    private static Random rand = new Random(47);
 
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
 
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}