package com.malaka.common.thread.multi.threadlocal;

public class MyThreadLocal {
	//定义了一个ThreadLocal变量，用来保存int或Integer数据 
    private ThreadLocal<Integer> tl = new ThreadLocal<Integer>() { 
            @Override 
            protected Integer initialValue() { 
                    return 0; 
            } 
    }; 

    public Integer getNextNum() { 
            //将tl的值获取后加1，并更新设置t1的值 
            tl.set(tl.get() + 1); 
            return tl.get(); 
    } 
}
