package com.multithreading.waitnotifynotifyall.working;

public class Consumer implements Runnable{
    
    private Product product;
    
    Consumer(Product product){
        this.product = product;
    }
    
    @Override
    public void run() {
        synchronized(product){
            try {
            	 System.out.println("Name  " +Thread.currentThread().getName());
                product.wait();
                Thread.sleep(1000);
                System.out.println("Consumer " +Thread.currentThread().getName()+"  gets notified");
                System.out.println(product);
            } catch (InterruptedException  e) {
                e.printStackTrace();
            }
        }
    }
}
