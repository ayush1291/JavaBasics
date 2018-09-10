package com.multithreading.joinandsleepwithlockchk.block.waitnotify;
public class HelloWorld{
	
	//Ques: 
	//annonymous inner classes
	// What is use of join
	// What happens if join is called without start
	// If wait is called directly, then illegal monitor state coz wait is called without its lock being acquired
	// wait, notify and notifyall is called only if lock is acquired, else illegal monitor state
	
	private static Object lockObject = new Object();

     public static void main(String []args) throws InterruptedException{
     //anonymous thread class
     Thread thread1 = new Thread(){
         public void run(){
        	 
        	 synchronized (lockObject) {
        		 Thread t1 = new MyThreadFirst(1, lockObject);
        		 t1.start();
        		 try {
        			 lockObject.wait();
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
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