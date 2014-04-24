package com.malaka.common.thread.multi.booleanlock;

public class MyThread implements Runnable{
	
	private String name;
	public MyThread(String name)
	{
		this.name = name;
	}
	
	@Override
	public void run() {
		
		while(!Test.isOver())
		{
			try {
				System.out.println(name+"--sleep---");
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

}
