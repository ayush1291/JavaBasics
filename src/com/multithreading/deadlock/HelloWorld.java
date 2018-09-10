package com.multithreading.deadlock;

public class HelloWorld{
	
// what is the state when thread wants the lock
	
     public static void main(String []args) throws InterruptedException{
        Object obj1 = new Object();
        Object obj2 = new Object();
    
        Thread t1 = new Thread(new UserThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new UserThread(obj2, obj1), "t2");
        
        t1.start();
        t2.start();
        
        while(true){
        	Thread.currentThread().sleep(1000);
        	System.out.println(t1.getState().name());
        	System.out.println(t2.getState().name());
        }
        	
     }
}
