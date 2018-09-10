package com.core.overriding;

// Take signature plus return type if overriding..only signature if overloading

// cannot make static to non static and vice versa

// Sattic are not overriden as senn in this example

public class Main {

	
	public static void main(String[] args) {
		
		First fir = new Second();		// here child method is called
		fir.hello(1, 2);
 
		fir.hello();					// Here parent is called
	}
}
