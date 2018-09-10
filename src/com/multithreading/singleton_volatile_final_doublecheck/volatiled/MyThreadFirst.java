package com.multithreading.singleton_volatile_final_doublecheck.volatiled;

public class MyThreadFirst extends Thread{
	
	int val;
	public MyThreadFirst(int val) {
		this.val=val;
		System.out.println(val);
	}
	
	@Override
	public void run() {
			
		try {
			Thread.sleep(1000);
			System.out.println(val+" is comeplete");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
