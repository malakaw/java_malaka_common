package com.malaka.common.thread.multi.threadlocal;

public class Test {
	public static void main(String[] args) { 
        MyThreadLocal tlt = new MyThreadLocal(); 
        Thread t1 = new TestThread(tlt); 
        Thread t2 = new TestThread(tlt); 
        Thread t3 = new TestThread(tlt); 
        Thread t4 = new TestThread(tlt); 
        t1.start(); 
        t2.start(); 
        t3.start(); 
        t4.start(); 

} 
}
