package com.malaka.common.thread.multi.Daemon;
/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.Daemon
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class Test {
	public static void main(String[] args) {
        Thread t1 = new MyCommon();
        Thread t2 = new Thread(new MyDaemon());
        t2.setDaemon(true);        //设置为守护线程

        t2.start();
        t1.start();
	} 
}
