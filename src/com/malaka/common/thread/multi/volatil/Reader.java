package com.malaka.common.thread.multi.volatil;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.volatil
 *创建日期：2014-1-7
 *作者：malaka.weng@vipshop.com
 */
public class Reader implements Runnable{

	Random ran ;
	VolatileUse vuse;
	ReadWriteLock lock;
	public Reader(VolatileUse vuse,ReadWriteLock lock)
	{
		 ran = new Random();
		 this.vuse = vuse;
		 this.lock = lock;
	}
	@Override
	public void run() {
		//System.out.println("in Reader");
		//lock.readLock().lock();
		String info = VolatileUse.getM("2");
		if(null ==info )System.out.println(info);
		//lock.readLock().unlock();
	}

}
