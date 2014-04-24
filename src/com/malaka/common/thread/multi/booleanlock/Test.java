package com.malaka.common.thread.multi.booleanlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.lock
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class Test {
	
	private static boolean over = false;
	
	public static boolean isOver()
	{
		return over; 
	}
	
	public static void setOver()
	{
		over = true;
	}
	
	public static void main(String[] args) {
	
        ExecutorService pool = Executors.newFixedThreadPool(2);
        
        pool.execute(new MyThread("t1"));
        pool.execute(new MyThread("t2"));
        
        pool.execute(new MyThread("t3"));
        pool.execute(new MyThread("t4"));
        pool.execute(new MyThread("t5"));
        try {
			Thread.sleep(2000);
			setOver();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        if(isOver())
        {
        	pool.shutdown(); 
        	System.out.println("shoutdown ...");
        }
	} 
}
