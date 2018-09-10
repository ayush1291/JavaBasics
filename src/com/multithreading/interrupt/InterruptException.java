package com.multithreading.interrupt;

public class InterruptException {
//When I call loop.interrupt(), a flag is set to true somewhere inside the thread loop. When I call interrupted(), the flag is returned and immediately set to false. 
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new MyRunnable());
		t.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t.interrupt();
	}
	
	public static class MyRunnable implements Runnable{
		
		@Override
		public void run() {
			int i=0;
			while(i<10000){
				System.out.println(i);
				i++;
				
			}
			
		}
		
	}
	
	
}
