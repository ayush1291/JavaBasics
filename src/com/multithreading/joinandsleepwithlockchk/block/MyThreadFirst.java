package com.multithreading.joinandsleepwithlockchk.block;

public class MyThreadFirst extends Thread{
	
	int val;
	Object lockObject;
	public MyThreadFirst(int val, Object object) {
		this.val=val;
		lockObject= object;
		System.out.println(val);
	}
	
	@Override
	public void run() {
		
		synchronized (lockObject) {
			try {
				System.out.println(val+" is comeplete");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
