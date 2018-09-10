package com.multithreading.daemonthread;

public class DaemonThread implements Runnable{
    
	Thread th;
	
	public DaemonThread(Thread th) {
		this.th=th;
		// TODO Auto-generated constructor stub
	}
    public void run(){
        try{
            while(true){
//                System.out.println("This is a daemon thread");
                System.out.println("Main thread name : "+ th.getName()+" "+th.getState().name());
                Thread.sleep(2000);
            }
        }
        catch(InterruptedException ex){
            System.out.println("Exception : " + ex.getMessage());
        }
    }
}