package com.malaka.common.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.file
 *创建日期：2014-1-26
 *作者：malaka.weng@vipshop.com
 */
public class FileRead {
	
	public static void read(String  fname)
	{
		InputStreamReader read = null;
		BufferedReader reader = null;
		FileLock genLock = null;
		
		try   
	    {       
	        File f = new File(fname);     
	        if(f.isFile()&&f.exists())  
	        {   
	        		
	        		read  = new InputStreamReader(new FileInputStream(f),"UTF8");  
		            reader=new BufferedReader(read);       
		            String line;       
		            while ((line = reader.readLine()) != null)   
		            {    
		            	System.out.println(line);
		            } 
	        }
	        else
	        {
	        	System.out.println("file not exist!!!");
	        }
	      
	    }
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
	
	public static FileLock getFileLock(File file) throws IOException {  
        RandomAccessFile fi = new RandomAccessFile(file, "rw");  
        FileChannel fc = fi.getChannel();  
        return fc.tryLock();  
    }  
	
	
	public static void main(String[] args) {
		String fn = "D:/tmp/ttt1.txt1";
		read(fn);
	}
}
