package com.multithreading.threadlocal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Random;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

//Notes"
// Why the start is called and not run directly
// why twice start cannot be called
// what happedns if negaive vakue in sleep method
// 

public class HelloWorld implements Runnable{

    //With this the default value obtained by each thread is different
    private static  Integer count = 0;
   
    private static final ThreadLocal<Integer> count1 = new ThreadLocal<Integer>(){
    	
        @Override
        protected Integer initialValue()
        {
            return 0;
        }
    };
   
    public static void main(String[] args) throws InterruptedException {
        HelloWorld obj = new HelloWorld();
        for(int i=0 ; i<50; i++){
            Thread t = new Thread(obj, ""+i);
            Collections.synchronizedMap(m)
            
           // t.setPriority(i+1);
            t.start();
            {
            	//Thread.currentThread().sleep(2000);
           	// System.out.println("Thread State during run"+ t.getName()+" "+t.getState().name());
           	 
            	//Thread.currentThread().sleep(3500);
            	// System.out.println("Thread State during run"+ t.getName()+" "+t.getState().name());
            }
        }
    }

    @Override
    public void run() {
    	
     //   System.out.println("Thread Name= "+Thread.currentThread().getName());
//        count ++;
//        System.out.println("count---"+count +"-------"+Thread.currentThread().getName());
        count1.set((Integer)count1.get() + 1);
        System.out.println("count1---"+count1.get()+"------" +Thread.currentThread().getName());
        
        
        
     //   System.out.println("Thread Name= "+Thread.currentThread().getName()+" new count = "+ count1.get());
     //   System.out.println("STate b4 sleep "+Thread.currentThread().getState().name());
     //   System.out.println("Name b4 sleep "+Thread.currentThread().getName());
        
                try {
			Thread.sleep(1);
		//	System.out.println("STate after sleep "+Thread.currentThread().getState().name());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //  System.out.println("Name after slee"+Thread.currentThread().getName());
    }

}