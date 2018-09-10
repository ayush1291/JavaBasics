package com.multithreading.deadlock;
class UserThread implements Runnable{
    private Object obj1;
    private Object obj2;

    public UserThread(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        
        synchronized (obj1) {
         System.out.println(name + " acquired lock on "+obj1);
         work();
         
         synchronized (obj2) {
            System.out.println(name + " acquired lock on "+obj2);
            work();
        }
         System.out.println(name + " released lock on "+obj2);
        }
        System.out.println(name + " released lock on "+obj1);
    }
    private void work() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}