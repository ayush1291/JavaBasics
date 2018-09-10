package com.multithreading.blockingqueue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    
    private BlockingQueue<Product> queue;
    
    Producer(BlockingQueue<Product> queue){
        this.queue = queue;
    }
    
    @Override
    synchronized public void run(){
        for(int i=0; i<5; i++){
            Product proudct = new Product("Product "+i);
            try {
                Thread.sleep(2000);
                queue.put(proudct);
                System.out.println("Produced-- "+proudct);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product proudct = new Product("last product");
        try {
            queue.put(proudct);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}