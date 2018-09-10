package com.multithreading.joinandsleepwithlockchk;
public class HelloWorld{
	
	//Ques: 
	//annonymous inner classes
	// What is use of join
	// What happens if join is called without start
	
	
	private Object lockObject = new Object();

     public static void main(String []args) throws InterruptedException{
     //anonymous thread class
     Thread thread1 = new Thread(){
         public void run(){
        	 
        	 //Join and sleep
        	/* Thread t1 = new MyThreadFirst(1);
        	 t1.start();
        	 try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 Thread t2 = new MyThreadFirst(2);
        	 */
         }
        };
        thread1.start();
        
    }
}