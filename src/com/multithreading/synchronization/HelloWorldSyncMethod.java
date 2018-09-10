package com.multithreading.synchronization;
import java.text.SimpleDateFormat;
import java.util.Random;

public class HelloWorldSyncMethod implements Runnable{
	
	//make run method synchronizable to avoid concurrency
	
    private static  Integer count = 0;
    public static void main(String[] args) throws InterruptedException {
        HelloWorld obj = new HelloWorld();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            t.start();
        }
    }

    @Override
    synchronized public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default count = "+ count);
        count = count +1;
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" new count = "+ count);
    }

}