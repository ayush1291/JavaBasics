package com.core.overload;

public class A {

	public static void main(String[] args) {
		
		B b = new B();
		C c = new C();
		B b1 = new C();
		
		one(b,b);
		one(b,b1);
		one(b,c);
	}
	
	
	
	
	
	public static class B{
		
	}
	
	public static class C extends B{
		
	}
	
	/*public static void one(B b, C c){		//uncomment this and see wat happens
		System.out.println("1");
	}*/
	
	public static void one(C b, B c){
		System.out.println("2");
	}
	
	public static void one(C b, C c){
		System.out.println("3");
	}
	
	public static void one(B b1, B b){
		if(b instanceof C) System.out.println("Yes");
		else System.out.println("No");
		System.out.println("4");
	}
}
