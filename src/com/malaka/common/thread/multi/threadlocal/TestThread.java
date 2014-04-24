package com.malaka.common.thread.multi.threadlocal;

public class TestThread extends Thread { 
    private MyThreadLocal tlt = new MyThreadLocal(); 

    public TestThread(MyThreadLocal tlt) { 
            this.tlt = tlt; 
    } 

    @Override 
    public void run() { 
            for (int i = 0; i < 3; i++) { 
                    System.out.println(Thread.currentThread().getName() + "\t" + tlt.getNextNum()); 
            } 
    } 

}
