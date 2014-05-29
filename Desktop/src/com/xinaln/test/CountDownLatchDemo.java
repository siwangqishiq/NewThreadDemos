package com.xinaln.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(100);
        
        final CountDownLatch latch = new CountDownLatch(1);
        service.submit(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println(" start  run ...."+Thread.currentThread());
                try
                {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println(" "+Thread.currentThread()+"---->end ");
            }
        });
        
        service.submit(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    latch.await();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println(" "+Thread.currentThread()+"---->end ");
            }
        });
        
        service.shutdown();
    }

}//end class
