package com.malaka.common.map;

import java.util.TreeMap;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.map
 *创建日期：2014-1-27
 *作者：malaka.weng@vipshop.com
 */
public class TreeMaptest {
	public static void main(String[] args) {
		
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		
		map.put("11", 11);
		map.put("2", 2);
		map.put("13", 13);
		map.put("1", 1);
		
		for(String k : map.keySet())
		{
			System.out.println(k);
		}
		
	}
}
