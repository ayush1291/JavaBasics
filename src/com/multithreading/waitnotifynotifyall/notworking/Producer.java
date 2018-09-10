package com.multithreading.waitnotifynotifyall.notworking;

public class Producer implements Runnable{
    
    private Product product;
    
    Producer(Product product){
        this.product = product;
    }
    
    @Override
    public void run() {
        System.out.println("Producer - START "+Thread.currentThread().getName());
        try {
            System.out.println("Producer notifies");
            product.setName(product.getName() + "  is being produced");
            product.notify();
        } catch (IllegalMonitorStateException  e) {
            e.printStackTrace();
        }
    }

}