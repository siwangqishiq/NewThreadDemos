package com.xinaln.test;

public class Test
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        int a = 2;
        int x = 2;
        
        System.out.println((10^2)^2);//xor
        A();
    }
    public static int i=1;
    
    private static void A(){
        i++;
        System.out.println("A   "+i);
        B();
    }
    
    private static void B(){
        i++;
        System.out.println("B   "+i);
        A();
    }


}//end class
