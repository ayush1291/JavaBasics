package com.multithreading.daemonthread;

public class HelloWorld{
	
	// What is daemaon thread- 
	// when can a daemon thread be created- before start or after start
	// what happens if only daemon threads is left in prgram
	// does the main thread gets terminated if other thread started from it is running

     public static void main(String []args){
        Thread thread1 = new Thread(new DaemonThread(Thread.currentThread()), "thread1");
//        thread1.setDaemon(true);
        thread1.start();
        
        System.out.println("Done");
        //Thread thread1 = new Thread(new DaemonThread(), "thread1");
     }
}
