package com.multithreading;

import com.multithreading.threadlocal.HelloWorld;

public class MyExceptionHandler implements Runnable{

    public static void main(String[] args) throws InterruptedException {
    	MyExceptionHandler obj = new MyExceptionHandler();
            Thread t = new Thread(obj);
            t.start();
            
    }

    @Override
    public void run() {
    	 Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

    	   	 public void uncaughtException(Thread thread, Throwable throwable) {

    	   	 System.out.println(thread.getName() + " has thrown " + throwable);

    	   	 }

    	   	 });
    int a= 9/0;
    }


	
}
