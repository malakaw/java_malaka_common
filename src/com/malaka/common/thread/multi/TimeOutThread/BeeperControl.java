package com.malaka.common.thread.multi.TimeOutThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.TimeOutThread
 *创建日期：2014-1-13
 *作者：malaka.weng@vipshop.com
 */
public class BeeperControl {
	
	
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
		 
	public void beepForAnHour() {
		     
			 final Runnable beeper = new Runnable() 
		     {
		       public void run() { System.out.println("beep"); }
		     };
		     
		     final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 1, TimeUnit.SECONDS);
		     
		     /**
		      * 延时200秒后停止
		      */
		     scheduler.schedule(new Runnable() 
		     						{
								       public void run() {
								    	   beeperHandle.cancel(true); 
								    	   System.out.println("close parent thread...");
								    	   scheduler.shutdown();
								       }
								    }, 4, TimeUnit.SECONDS);
		     
		     //scheduler.shutdown();
	}
	
	public static void main(String[] args) {
		new BeeperControl().beepForAnHour();
	}
}
