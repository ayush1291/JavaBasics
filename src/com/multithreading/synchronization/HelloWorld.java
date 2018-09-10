package com.multithreading.synchronization;
public class HelloWorld implements Runnable{

    private static  Integer count = 0;
    public static void main(String[] args) throws InterruptedException {
        HelloWorld obj = new HelloWorld();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            t.start();
        }
    }

    @Override
    public void run() {
    	synchronized(count){
        //synchronized(this){
            System.out.println("Thread Name= "+Thread.currentThread().getName()+" default count = "+ count);
            count = count +1;
            System.out.println("Thread Name= "+Thread.currentThread().getName()+" new count = "+ count);
        }
    }

}