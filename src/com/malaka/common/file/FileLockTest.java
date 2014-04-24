package com.malaka.common.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.file
 *创建日期：2014-1-26
 *作者：malaka.weng@vipshop.com
 */
public class FileLockTest {
	public static void main(String[] args){
        FileChannel channel = null;
        FileLock lock = null;
        try {
            
        	File f = new File("D:/tmp/ttt1.txt1");
            RandomAccessFile raf = new RandomAccessFile("D:/tmp/ttt1.txt1","rw");
            raf.seek(raf.length());//raf在文件末尾追加内容的处理
            channel = raf.getChannel();
            
//            获得锁方法一lock，阻塞的方法，当文件锁不可用时，当前进程会被挂起
//            lock = channel.lock(0L, Long.MAX_VALUE, true);//共享锁，有写操作会报异常
            lock = channel.lock();//独占锁
            
//            获得锁方法二trylock，非阻塞的方法，当文件锁不可用时，tryLock()会得到null值
//            do {
//                lock = channel.tryLock();
//            } while(null == lock);

//            互斥操作
            ByteBuffer sendBuffer=ByteBuffer.wrap((new Date()+" 写入\n").getBytes());
            channel.write(sendBuffer);
            Thread.sleep(5000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock != null) {
                try {
                    lock.release();
                    lock = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(channel != null) {
                try {
                    channel.close();
                    channel = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
