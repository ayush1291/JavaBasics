package com.multithreading.creation;

public class HelloWorld{
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
     public static void main(String []args){
     Thread thread1 = new ThreadCreationByThreadClass();
     thread1.start();
     System.out.println("Thread1 started");
     
     System.out.println("--Runnable interface");
     ThreadCreationByRunnable threadCreationByRunnable = new ThreadCreationByRunnable();
     Thread thread2 = new Thread(threadCreationByRunnable);
     thread2.start();
     }
}