package com.malaka.common.thread.multi.Semaphore;

import java.util.concurrent.Semaphore;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.Semaphore
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class MyPool {
	
	private Semaphore sp;     //池相关的信号量

    /**
     * 池的大小，这个大小会传递给信号量
     *
     * @param size 池的大小
     */
    MyPool(int size) {
            this.sp = new Semaphore(size);
    }

    public Semaphore getSp() {
            return sp;
    }

    public void setSp(Semaphore sp) {
            this.sp = sp;
    } 
}
