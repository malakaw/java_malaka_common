package com.malaka.common.thread.multi.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.Semaphore
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class Test {
	public static void main(String[] args) {
        MyPool myPool = new MyPool(13);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        MyThread t1 = new MyThread("任务A", myPool, 3);
        MyThread t2 = new MyThread("任务B", myPool, 12);
        MyThread t3 = new MyThread("任务C", myPool, 7);
        //在线程池中执行任务
        threadPool.execute(t1);
        threadPool.execute(t2);
        threadPool.execute(t3);
        //关闭池
        threadPool.shutdown();
	} 
}
