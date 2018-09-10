package com.multithreading.example;

//Sleep method is only called from the thread which is calling it as it is a static method 


public class Eg1 {
   	public static void main(String... args) throws InterruptedException {
 
          	System.out.println(Thread.currentThread().getName() + " has started");
 
          	Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
          	thread1.sleep(10000);
          	thread1.start();
          	System.out.println(Thread.currentThread().getName() + " has ended");
 
   	}
   	
   	
   	static class MyRunnable implements Runnable {
   	   	public void run() {
   	 
   	          	System.out.println(Thread.currentThread().getName() + " has started");
//   	          	try {
//   	                 	Thread.sleep(100); //ensure that main thread don’t complete before Thread-1
//   	          	} catch (InterruptedException e) {
//   	                 	e.printStackTrace();
//   	          	}
   	          	System.out.println(Thread.currentThread().getName() + " has ended");
   	 
   	   	}
   	}
}


