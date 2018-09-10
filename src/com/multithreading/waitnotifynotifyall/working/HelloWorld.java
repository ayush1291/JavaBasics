package com.multithreading.waitnotifynotifyall.working;

public class HelloWorld{
	
	// wait notify and notifyAll are object methods
	// lock is a property of objects
	// what happens if no lock or class level lock is acquired  and wait method is called
	// what happens if no other class acquires the lock or notifies which is released in wait method
	// is there one jvm for one application
	// what happens if only one notify is called and notifyAll is not called 
	// what happens if notifyAll is called twice
	// whta happens if join is called instead of notify 
	
     public static void main(String []args) throws InterruptedException{
       Product product = new Product("Strawberry ice cream");
       Consumer consumer1 = new Consumer(product);
       Thread c1 =  new Thread(consumer1,"consumer1");
       c1.start();
        Consumer consumer2 = new Consumer(product);
       Thread c2 =new Thread(consumer2,"consumer2");
       c2.start();
       Producer producer = new Producer(product,c1);
       Thread p1 =  new Thread(producer,"producer");
       p1.start();
        
       int i=100;
        while(i<3000){
        	Thread.currentThread().sleep(500);
        	System.out.println(" 1 "+c1.getState().name());
        	System.out.println("2  "+c2.getState().name());
        	System.out.println(" 3 "+p1.getState().name());
        	i+=200;
        }
    }
}