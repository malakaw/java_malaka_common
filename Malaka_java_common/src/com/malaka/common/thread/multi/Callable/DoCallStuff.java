package com.malaka.common.thread.multi.Callable;

import java.util.concurrent.Callable;

/**
 *项目名：Malaka_java_common
 *包名：com.malaka.common.thread.multi.Callable
 *创建日期：2013-12-20
 *作者：malaka.weng@vipshop.com
 */
public class DoCallStuff implements Callable<String>{ // *1

    private int aInt;
    public DoCallStuff(int aInt) {
            this.aInt = aInt;
    }

    public String call() throws Exception { //*2
            boolean resultOk = false;
            if(aInt == 0)
            {
            	Thread.sleep(3000);
                    resultOk = true;
            }  
            else if(aInt == 1)
            {
                    while(true)
                    { //infinite loop
                            System.out.println("looping....");
                            Thread.sleep(3000);
                    }
            } else 
            {
                    throw new Exception("Callable terminated with Exception!"); //*3
            }

            if(resultOk)
            {
                    return "Task done.";
            } 
            else 
            {
                    return "Task failed";
            }
    }

}
