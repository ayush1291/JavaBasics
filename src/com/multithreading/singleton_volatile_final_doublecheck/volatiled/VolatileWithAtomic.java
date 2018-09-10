package com.multithreading.singleton_volatile_final_doublecheck.volatiled;

import java.util.concurrent.atomic.AtomicInteger;

import com.multithreading.singleton_volatile_final_doublecheck.volatiled.Singleton.T2;

// There is a big performance hit incase of using volatile
// Try removing volatile and seing the time of o/p
// Though we use volatile, still we wont get the exact value coz a++ is not atomic opration,
//	we shud use Atomic INteger

public class VolatileWithAtomic {

	public AtomicInteger atomicInteger=new AtomicInteger(10);
	Thread t1;

	private static Object mutex = new Object();

	public static void main(String[] args) throws InterruptedException {
		VolatileWithAtomic singleton = new VolatileWithAtomic();
		singleton.startExecute();
		
	}

	public void startExecute() {
		
		final T2 t2  = new T2();
		t2.start();

		t1 = new Thread() {
			@Override
			public void run() {
				System.out.println(" Starting thread 1");
				atomicInteger.incrementAndGet();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ti---"+atomicInteger.get());
				
			}
		};
		t1.start();
		
		
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main---"+a);*/
		
	}

	class T2 extends Thread{
		
		int a1 ;
		
		@Override
		public void run() {
			System.out.println(" Starting thread 2");
			int i = 0;
			
				while (i < 1000000000) {
					atomicInteger.incrementAndGet();
					i++;
				}
				System.out.println("t2---"+atomicInteger.get());
				
		}
	};
	
	public VolatileWithAtomic() {
		// TODO Auto-generated constructor stub
	}

}