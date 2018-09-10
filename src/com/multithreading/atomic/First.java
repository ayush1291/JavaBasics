package com.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class First {

	AtomicInteger integer = new AtomicInteger();
	
	public static void main(String[] args) {
		First f = new First();
		f.run1();
		f.run2();
		
		
	}
	
	void run1(){
		
		for(int j=0; j<100; j++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					for(int i=0; i<200; i++){
						System.out.println(integer.incrementAndGet() + " Thread "+Thread.currentThread().getName());
					}
				}
			}).start();
		}
		
	}
	
	void run2(){
		
		for(int j=0; j<100; j++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i=0; i<200; i++){
						System.out.println(integer.incrementAndGet()+"  Thread "+Thread.currentThread().getName());
					}
				}
			}).start();
		}
		
	}
}
