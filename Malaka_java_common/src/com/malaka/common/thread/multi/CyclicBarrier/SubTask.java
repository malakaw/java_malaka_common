package com.malaka.common.thread.multi.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.CyclicBarrier
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class SubTask extends Thread {
    private String name;
    private CyclicBarrier cb;

    SubTask(String name, CyclicBarrier cb) {
            this.name = name;
            this.cb = cb;
    }

    public void run() {
            System.out.println("[子任务" + name + "]开始执行了！");
            for (int i = 0; i < 999999; i++) ;    //模拟耗时的任务
            System.out.println("[子任务" + name + "]开始执行完成了，并通知障碍器已经完成！");
            try {
                    //通知障碍器已经完成
                    cb.await();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            } catch (BrokenBarrierException e) {
                    e.printStackTrace();
            }
    } 

}
