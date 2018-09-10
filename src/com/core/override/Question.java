package com.core.override;



//Multi level inheritance 

//In the Java programming language, a method signature is the method name and the number, type and order of its 
//parameters. Return types and thrown exceptions are not considered to be a part of the method signature.

//why is it that modifiers are not allowed to decrease visibility


public class Question {

	public static void main(String[] args) {
//		A a = new C();
		
		A a = new A();
		B1 a1 = (B1)a.run();
		a1.run2();
		
//		C1 a1 = (C1)a.run(); // not allowed
		
	}
	
	static class A{
		A1 run() {
			System.out.println("A");
			return new A1();
		}
	}
	
	static class B extends A{
		
		B1 run(){
			System.out.println("B");
			return new B1();
		}
	}
	
	static class C extends B{
		
		B1 run(){
			System.out.println("C");
			return null;
		}
	}
	
	/*static class D extends C{
		
		void run(){
			System.out.println("D");
		}
	}*/
	
	
	static class A1{
		void run(){
			System.out.println("A1");
		}
	}
	
	static class B1 extends A1{
		void run(){
			System.out.println("B1");
		}
		
		void run2(){
			System.out.println("B22");
		}
	}
	
	static class C1{
		void run(){
			System.out.println("C1");
		}
	}
}
