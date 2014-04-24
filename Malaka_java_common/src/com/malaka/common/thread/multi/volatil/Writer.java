package com.malaka.common.thread.multi.volatil;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.volatil
 *创建日期：2014-1-7
 *作者：malaka.weng@vipshop.com
 */
public class Writer implements Runnable{
	
	Random ran ;
	VolatileUse vuse ;
	ReadWriteLock lock ;
	public Writer(VolatileUse vuse ,ReadWriteLock lock)
	{
		ran = new Random();
		this.vuse = vuse;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		//System.out.println("in writer");
		HashMap<String,String> map = new HashMap<String,String>();
		for(int i = 0;i <6;i++)
		{
			//map.put(""+ran.nextInt(10), ran.nextInt(10)+"");
			map.put(""+i, i+"");
		}
		//lock.writeLock().lock();
		VolatileUse.updateM(map);
		//lock.writeLock().unlock();
	}

}
