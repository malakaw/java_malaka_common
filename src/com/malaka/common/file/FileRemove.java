package com.malaka.common.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileLock;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.file
 *创建日期：2014-1-26
 *作者：malaka.weng@vipshop.com
 */
public class FileRemove {
	
	public static void remove(String  fname)
	{
		InputStreamReader read = null;
		BufferedReader reader = null;
		try   
	    {       
	        File f = new File(fname);     
	        if(f.isFile()&&f.exists())  
	        {   
	        	 f.delete();
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
	
	public static void main(String[] args) {
		String fn = "D:/tmp/ttt1.txt1";
		remove(fn);
	}
}
