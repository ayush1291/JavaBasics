package com.core.overriding;

public class First {		// decalre as final if no inheritance needed

	
	public void  hello(int a, int b){
		
		System.out.println("Parent override instance method");
	}
	
	public static void hello() {

		System.out.println("Parent statuc method invoked");
	}

	
	public void  notoverride(int a){
		
		System.out.println("Parent not override method");
	}
	
	public final void notNeeded(){			// if no overriding needed
		
		System.out.println(" PArent not needed");
	}
}
