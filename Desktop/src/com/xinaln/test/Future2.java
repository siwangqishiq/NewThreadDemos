package com.xinaln.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Future2
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ExecutorService s = Executors.newFixedThreadPool(7);
        Future<String> f = s.submit(new Callable<String>()
        {

            @Override
            public String call() 
            {
                try
                {
                    Thread.sleep(4000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                return "ÄãºÃ ÊÀ½ç!";
            }
        });
        
        try
        {
            System.out.println(f.get());
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
        
        s.shutdown();
    }

}
