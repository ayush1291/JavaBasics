package com.core.staticPnonStaticC;

//Compiler will give error if trying to override a static method

public class Main {
	
	public static void main(String[] args) {
		
	}
	
	static class P{
		public  void add(){
			System.out.println("P");
		}
	}
	
	static class C extends P{
		
		public void add(){
			System.out.println("C");
		}
	}

}
