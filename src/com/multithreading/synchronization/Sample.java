package com.multithreading.synchronization;

public class Sample {
	
	
	public static void main(String[] args) {
		
		
		
		final Sample sampleLock = new Sample();
		
		final Sample sample3 = sampleLock;
		
		final Sample sample2Lock = new Sample();
		
		new Thread(){
			public void run() {
				sampleLock.sample(1);
			};
		}.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(){
			public void run() {
				sample2Lock.sample(2);
				
				sample3.sample2(3);
				
				sampleLock.sample2(1);
			};
		}.start();
		
	}
	
	
	public static synchronized void sample(Integer a){
		System.out.println("Sample called by "+a);
		
		try {
			a.wait();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void sample2(int a){
		System.out.println("Sample2 called by "+a);
	}

}
