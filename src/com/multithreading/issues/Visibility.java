package com.multithreading.issues;

public class Visibility {

	//This can be removed if we use volatile
	public boolean a;
	public boolean b;

	public static void main(String[] args) throws InterruptedException {
		Visibility f = new Visibility();
		f.run();
		Thread.sleep(1000);
		f.a=true;
		f.b=true;
		System.out.println("Im done");
	}

	void run() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!a && !b) {
					System.out.println(a+" "+b);
				}
				System.out.println(a);

			}
		}).start();
	}
}
