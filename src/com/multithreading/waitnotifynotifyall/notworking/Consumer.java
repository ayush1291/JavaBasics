package com.multithreading.waitnotifynotifyall.notworking;

public class Consumer implements Runnable{
    
    private Product product;
    
    Consumer(Product product){
        this.product = product;
    }
    
    @Override
    public void run() {
        System.out.println("Consumer - START "+Thread.currentThread().getName());
        try {
            System.out.println("Consumer is waiting");
            product.wait();
            System.out.println("Consumer gets notified");
            System.out.println(product);
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }
    }

}
