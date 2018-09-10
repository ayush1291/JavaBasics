package com.core.override;

public class Ploy extends A{

	public static void main(String[] args) {
		
		Ploy p1 = new Ploy();
		A a = new A();
		A a1= new Ploy();
		p1.vehicle();
		a.vehicle();
		a1.vehicle();
		
		p1.vehicle2();
		a.vehicle2();	//  dynamic binding or late binding- run time
		a1.vehicle2();
		
		
		
		
		System.out.println(get(1,1));// Compile time polymorphism or  compile time polymorphism or static binding
//		System.out.println(get(1,new Integer(1)));
		System.out.println(get(new Integer(1),new Integer(1)));
		System.out.println(get(1,1));
		System.out.println(get(1.1,1));
		
		
	}
	
	public void vehicle() {
		System.out.println("Vehicle in Ploy");
	}
	
	public static void vehicle2() {
		System.out.println("Vehicle in Ploy");
	}
	
	public static int get(int a, int b){
		System.out.println();
		return 0;
	}
	
	public static int get(Integer a, Integer b){
		System.out.println();
		return 2;
	}
	
	public static int get(double a, double b){
		System.out.println();
		return 3;
	}
	
	/*public String vehicle2(int a) {		// This is not allowed in method overriding
		System.out.println("Vehicle in A");
		return 1;
	}*/
	
	
	/*protected  int vehicle2(int a, int b) { // less restriction is not allowed
		System.out.println("Vehicle in A");
		return 0;
	}*/
}
