package com.multithreading.singleton_volatile_final_doublecheck.volatiled;

// There is a big performance hit incase of using volatile
// Try removing volatile and seing the time of o/p
// Though we use volatile, still we wont get the exact value coz a++ is not atomic opration,
//	we shud use Atomic INteger
//If we add two three statements after a++, thebn probably the value is written in the memory by the time,
//	so we may get correct answer

//Note: volatile is not reqd if only one thread is there

public class Singleton {

	public volatile int a = 11;
	Thread t1;

	private static Object mutex = new Object();

	public static void main(String[] args) throws InterruptedException {
		Singleton singleton = new Singleton();
		singleton.startExecute();
		
	}

	public void startExecute() {
		
		final T2 t2  = new T2();
		t2.start();

		t1 = new Thread() {
			@Override
			public void run() {
				System.out.println(" Starting thread 1");
				a++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ti---"+a);
				
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
					a++;
					i++;
				}
				System.out.println("t2---"+a);
				
		}
	};
	
	private Singleton() {
	}

}