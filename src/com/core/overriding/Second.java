package com.core.overriding;

public class Second extends First{

	public void hello(){				// Override
		
		System.out.println("Second");
	}

	public static void hello(int a){		// Overload
		
		System.out.println("Second");
	}
	
//	public void hello(){					// Cannot be done
//		
//	}
	
	public void hello(int a, int b){					
		System.out.println("Child");
	}
	
	public final void notNeeded(){						// Cannot override final methods
		
		System.out.println(" PArent not needed");
	}
	
//	public int hello(int a, int b){					// Cannot be done
//		System.out.println("Child");
//	}
	
}
