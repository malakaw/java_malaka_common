package com.malaka.common.thread.multi.volatil;

import java.util.HashMap;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.volatil
 *创建日期：2014-1-7
 *作者：malaka.weng@vipshop.com
 */
public class VolatileUse {
	
	
	private volatile static HashMap<String,String> pmap = new HashMap<String,String>() ;
	
	
	public static String getM(String key)
	{
			return pmap.get(key);
	}
	
	
	public static void updateM(HashMap<String,String> newMap)
	{
		 pmap = new HashMap<String,String>(newMap);
		 newMap.clear();
		 newMap = null;
	}
}
