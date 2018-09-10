package com.multithreading.pool;

public class RunnableObject implements Runnable{
	int a;
	
	public RunnableObject(int a) {
		this.a=a;
	}
	public RunnableObject() {
		
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(a);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed" +a);
	}

}
