package com.xinaln.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo
{
    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(20);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        for(int i=0;i<100;i++)
        {
            futures.add(service.submit(new Callable<Integer>()
            {
                @Override
                public Integer call() throws Exception
                {
                    System.out.println(Thread.currentThread()+"   run...");
                    Thread.sleep(2000);
                    int ret = (int)(Math.random()*1000);
                            
                    System.out.println(Thread.currentThread()+"   run... value="+ret);
                    return ret;
                }
            }));
        }//end for 
        
        
        int total = 0;
        for(Future<Integer> f:futures)
        {
            try
            {
                total+=f.get();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
            }
        }//end for
        System.out.println("   total ----->"+total);
        
        service.shutdown();
    }

}//end class
