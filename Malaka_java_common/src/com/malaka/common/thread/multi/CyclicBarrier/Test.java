package com.malaka.common.thread.multi.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.CyclicBarrier
 *创建日期：2013-12-3
 *作者：malaka.weng@vipshop.com
 */
public class Test {
	 public static void main(String[] args) {
         //创建障碍器，并设置MainTask为所有定数量的线程都达到障碍点时候所要执行的任务(Runnable)
         CyclicBarrier cb = new CyclicBarrier(4, new MainTask());
         new SubTask("A", cb).start();
         new SubTask("B", cb).start();
         new SubTask("C", cb).start();
         new SubTask("D", cb).start();
         new SubTask("E", cb).start();
         new SubTask("F", cb).start();
         new SubTask("G", cb).start();
   } 
}
