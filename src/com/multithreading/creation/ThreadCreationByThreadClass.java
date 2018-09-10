package com.multithreading.creation;

public class ThreadCreationByThreadClass extends Thread{
    
    public ThreadCreationByThreadClass() {
        super();
    }
    
    public ThreadCreationByThreadClass(String name) {
        super(name);
    }

   /* @Override
    public void run() {
    	System.out.println("STate b4 sleep "+Thread.currentThread().getState().name());
    	System.out.println("ThreadCreationByThreadClass - START "+Thread.currentThread().getName());
        
        try {
            Thread.sleep(5000);
            System.out.println("STate after slee"+Thread.currentThread().getState().name());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadCreationByThreadClass - END "+Thread.currentThread().getName());
    }*/

}
