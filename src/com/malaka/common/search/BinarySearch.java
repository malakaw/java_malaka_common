package com.malaka.common.search;

import java.util.HashMap;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.search
 *创建日期：2013-12-31
 *作者：malaka.weng@vipshop.com
 */
public class BinarySearch {
	
	static int separateSearch(int[] intArray, int number)
    {
        int left = 0;
        int right = intArray.length - 1;
        while (left <= right)
        {
            int middle = left + ((right - left) >> 1);
            if (number == intArray[middle])
            {
                return middle;
            }
            else if (number < intArray[middle])
            {
                right = middle - 1;
            }
            else
            {
                left = middle + 1;
            }
        }
        return -1;
    }
	
	public static void test()
	{
		int[] arr= new int[10000];  
		for(int i =0 ;i<10000;i++)
		{
			arr[i] = i;
		}
	    try {
	    	long s1 = System.nanoTime();	
	    	//int resul = separateSearch(arr,9);
	    	for(int j = 0 ;j<2000;j++)
	    	{
	    		java.util.Arrays.binarySearch(arr, j);  
	    		
	    	}
	    	System.out.println("binaraay search -1-"+(System.nanoTime() -s1));
	    	//System.out.println(resul);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    long s2 = System.nanoTime();	
    	//int resul = separateSearch(arr,9);
	    for(int j = 0 ;j<2000;j++)
	    {
	    	int tom = arr[9];  
	    }
    	System.out.println("array search  -2-"+(System.nanoTime() -s2));
    	//System.out.println(resul);
       
	}
	
	
	public static void main(String[] args) {
		test();
		
		
		HashMap<String,Integer> map =new HashMap<String,Integer>();
		for(int i =0 ;i<2000;i++)
		{
			map.put(i+"", i+2);
		}
		long s1 = System.nanoTime();
		for(int j = 0 ;j<2000;j++)
		{
			map.get(""+j);
		}
		System.out.println("hashmap search "+(System.nanoTime() -s1));
		System.out.println(System.nanoTime() );
		HashMap<String,Integer> map2 =new HashMap<String,Integer>(map);
		map = null;
		map2.get("8");
		
		
	}
	
}
