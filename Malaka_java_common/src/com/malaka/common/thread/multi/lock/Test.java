package com.malaka.common.thread.multi.lock;

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
	
	public static void main(String[] args) {
		//创建并发访问的账户
        MyCount myCount = new MyCount("95599200901215522", 10000);
        //创建一个锁对象
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建一些并发访问用户，一个信用卡，存的存，取的取，好热闹啊
        User u1 = new User("张三", myCount, -4000, lock, false);
        User u2 = new User("张三他爹", myCount, 6000, lock, false);
        User u3 = new User("张三他弟", myCount, -8000, lock, false);
        User u4 = new User("张三", myCount, 800, lock, false);
        User u5 = new User("张三他爹", myCount, 0, lock, true);
        //在线程池中执行各个用户的操作
        for(int i =0;i<10;i++)
        {
        	 pool.execute(u1);
             pool.execute(u2);
             pool.execute(u3);
             pool.execute(u4);
             pool.execute(u5);
        }
        //关闭线程池
        pool.shutdown(); 
} 
}
