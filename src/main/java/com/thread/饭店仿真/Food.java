/*
 * @文 件 名: Food.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述: (用一句话描述该文件做什么)
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年6月9日 上午11:13:17
 */
package com.thread.饭店仿真;

/**
 * @文 件 名: Food.java
 * @版 权: 灭霸指挥中心. Copyright 2014-2020, All rights reserved
 * @描 述:
 * @版 本: 1.0
 * @创 建 人: 0216000799
 * @创建时间: 2018年6月9日 上午11:13:17
 */
public interface Food {
	
	enum Appetizer implements Food {
		SALAD, SOUP, SPRING_ROLLS
	}
	
	enum MainCourse implements Food {
		LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
	}
	
	enum Dessert implements Food {
		TIRAMISU, GELATO, BACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
	}
	
	enum Coffee implements Food {
		BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
	}
}
