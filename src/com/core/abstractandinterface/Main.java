package com.core.abstractandinterface;


public class Main implements MyInterface1, MyInterface2{

	// Two interface with same method but, if return type is different, then compile time error
	
	// If default methods are there with same signature in two different interfaces, then it is necessary to implement taht method
	//	else we will have a compile time error
	
	//	
	
	
	public static void main(String[] args) {
		Main ma = new Main();
		
	}

	@Override
	public void main() {
		// TODO Auto-generated method stub
		
	}
	

}
