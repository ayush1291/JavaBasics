package com.multithreading.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    
    private BlockingQueue<Product> queue;
    
    public Consumer(BlockingQueue<Product> queue){
        this.queue=queue;
    }
    
    @Override
    synchronized public void run(){
        try{
            Product product;
            Thread.sleep(1000);
            while((product = queue.take()).getName() !="last product"){
                System.out.println("Consumed "+product);
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
