package com.overridingmethodInConstructor;

//Here, we see that child method is invoked before its constructor is finished.

public class Main {
	
	public static void main(String[] args) {
		Child ch = new Child();
	}
	
	static class Parent{
		public Parent() {
			go();
		}
		
		public void go(){
			System.out.println("Parent");
		}
	}
	
	static class Child extends Parent{
		int x;
		
		public Child() {
			super();
			x=2;
			System.out.println("Constructing child");
		}
		public void go(){
			System.out.println("Child "+x);
		}
	}

}
