package com.multithreading.joinandsleepwithlockchk;

public class MyThreadSecond extends Thread{
	
	int val;
	
	public MyThreadSecond(int val) {
		System.out.println(val);
		this.val=val;
	}
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println(val+" is comeplete");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
