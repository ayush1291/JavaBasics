package com.multithreading.joinandsleepwithlockchk.block;
public class HelloWorld{
	
	//Ques: 
	//annonymous inner classes
	// What is use of join
	// What happens if join is called without start
	
	
	private static Object lockObject = new Object();

     public static void main(String []args) throws InterruptedException{
     //anonymous thread class
     // This eg creates a deadlock situation
     Thread thread1 = new Thread(){
         public void run(){
        	 
        	 synchronized (lockObject) {
        		 Thread t1 = new MyThreadFirst(1, lockObject);
            	 t1.start();
            	 System.out.println("Sleeping main");
            	 
            	 try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
            	 
            	 System.out.println("Woke up main");
            	 
            	 try {
    				t1.join();
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
			}
        	System.out.println("Main thread is complete");
        	
         }
        };
        thread1.start();
        
    }
}