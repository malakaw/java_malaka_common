package com.malaka.common.thread.multi.Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.Atomic
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class Test {
	
	 public static void main(String[] args) {
         ExecutorService pool = Executors.newFixedThreadPool(2);
         Lock lock = new ReentrantLock(false);
         Runnable t1 = new MyRunnable("张三", 2000,lock);
         Runnable t2 = new MyRunnable("李四", 3600,lock);
         Runnable t3 = new MyRunnable("王五", 2700,lock);
         Runnable t4 = new MyRunnable("老张", 600,lock);
         Runnable t5 = new MyRunnable("老牛", -1300,lock);
         Runnable t6 = new MyRunnable("胖子", 800,lock);
         //执行各个线程
         pool.execute(t1);
         pool.execute(t2);
         pool.execute(t3);
         pool.execute(t4);
         pool.execute(t5);
         pool.execute(t6);
         //关闭线程池
         pool.shutdown();
 } 
}
