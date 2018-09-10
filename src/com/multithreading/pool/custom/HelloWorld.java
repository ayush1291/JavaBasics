package com.multithreading.pool.custom;

public class HelloWorld{

     public static void main(String[] args) throws Exception {
           System.out.println("Create pool first with two threads");
           ThreadPool threadPool=new ThreadPool(2);  
           Runnable task1=new Runnable(){
               public void run() {
                       try {
                              Thread.sleep(500);
                              System.out.println(Thread.currentThread().getName() +" is executing task 1.");
                       } catch (InterruptedException e) {
                              e.printStackTrace();
                       }
                }
           };
           Runnable task2=new Runnable(){
               public void run() {
                       try {
                              Thread.sleep(500);
                              System.out.println(Thread.currentThread().getName() +" is executing task 2.");
                       } catch (InterruptedException e) {
                              e.printStackTrace();
                       }
                }
           };
          
           threadPool.execute(task1);
           threadPool.execute(task2);
           Thread.sleep(5000);
           threadPool.shutdown();
            System.out.println("Add task..post shut down initated");
           threadPool.execute(task2);
           
    }
}
