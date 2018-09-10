package com.core.override;

public class A {
	
	
	public void vehicle() {
		System.out.println("Vehicle in A");
		
	}

	public static void vehicle2() {
		System.out.println("Vehicle in A");
		
	}
	
	public  int vehicle2(int a) {
		System.out.println("Vehicle in A");
		return 0;
	}
	
	public  int vehicle2(int a, int b) {
		System.out.println("Vehicle in A");
		return 0;
	}
}
