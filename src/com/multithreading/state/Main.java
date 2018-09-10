package com.multithreading.state;

public class Main {

	// Suppose you have thread and it is in static synchronized method 
//	and now can thread enter other non static synchronized method from that method? - 2 locks -nested synchronization
	
	public static void main(String[] args) {
		
		Thread th = new Thread(){
			
			@Override
			public synchronized void start() {
				System.out.println("Overrided");
			}
			
		};
		System.out.println(th.getState().toString());
		
		th.start();
		
		System.out.println(th.getState().toString());
		
		
	}
	
}
