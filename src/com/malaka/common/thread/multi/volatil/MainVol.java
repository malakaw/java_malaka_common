package com.malaka.common.thread.multi.volatil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.volatil
 *创建日期：2014-1-7
 *作者：malaka.weng@vipshop.com
 */
public class MainVol {
	
	
	public static void main(String[] args) {
		VolatileUse vu = new VolatileUse();
		ReadWriteLock lock = new ReentrantReadWriteLock(false);
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Writer w1 = new Writer(vu,lock);
		Writer w2 = new Writer(vu,lock);
		Reader r1 = new Reader(vu,lock);
		Reader r2 = new Reader(vu,lock);
		pool.execute(w1);
        //在线程池中执行各个用户的操作
        for(int i =0;i<610;i++)
        {
        	 pool.execute(w1);
        	 pool.execute(r1);
        	 pool.execute(w2);
        	 pool.execute(r2);
        	 pool.execute(w1);
        	 pool.execute(r1);
        	 pool.execute(w2);
        	 pool.execute(r2);
        }
        //关闭线程池
        pool.shutdown(); 
	}
}
