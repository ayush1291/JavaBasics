package com.multithreading.waitnotifynotifyall.working;

public class Producer implements Runnable{
    
    private Product product;
    private Thread th;
    
    Producer(Product product, Thread th){
        this.product = product;
        this.th=th;
    }
    
    @Override
    public void run() {
        synchronized(product){
            try {
                try {
                	System.out.println("Producer is working");
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("Producer is notifying");
                product.notifyAll();
            } catch (IllegalMonitorStateException  e) {
                e.printStackTrace();
            }
        }
    }

}