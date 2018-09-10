package com.multithreading.creation;

public class ThreadCreationByRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("ThreadCreationByRunnable - START "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadCreationByRunnable - END "+Thread.currentThread().getName());
    }
}
