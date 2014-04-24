package com.malaka.common.thread.multi.Daemon;
/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.Daemon
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class MyCommon extends Thread {
    public void run() {
        for (int i = 0; i < 1105; i++) {
                System.out.println("线程1第" + i + "次执行！");
                try {
                        Thread.sleep(7);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }
} 

}
