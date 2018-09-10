package com.core.circularandflow;

public final class Main implements IMain{
	
	//Happens when the JVM does not know what is the memory requirement for objects
	// Resolved bt passing interface or reference which does not bother abt the memory requirement
	//Also chk the sequnce of execution
	//First- memory is allocated for all variables and reference is created
	//Then the instances are crated
	
	Lift lift2 = new Lift(this,"2");
	
	Lift lift = new Lift(this,"1");
	
	
	int i=2;

	
	public Main() {
//		lift = new Lift(this);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		Main m = new Main();
		
		System.out.println("i= "+m.i);
	}
}
