package com.malaka.common.thread.multi.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.Callable
 *创建日期：2013-12-20
 *作者：malaka.weng@vipshop.com
 */
public class Executor {
	public static void main(String[] args){

        //*1
        DoCallStuff call1 = new DoCallStuff(0);
        DoCallStuff call2 = new DoCallStuff(1);
        DoCallStuff call3 = new DoCallStuff(2);

        //*2
        ExecutorService es = Executors.newFixedThreadPool(3);

        //*3
        Future<String> future1 = es.submit(call1);
        Future<String> future2 = es.submit(call2);
             Future<String> future3 = es.submit(call3);
        try {
			System.out.println(future1.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
        es.shutdown();
        
	}
}
