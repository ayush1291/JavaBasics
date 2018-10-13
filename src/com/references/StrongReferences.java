package com.references;

//ny object with an active strong reference to it, will never be garbage
//collected(except in rare circumstances, such as cyclical references).

//What if i want sth to stay in memory even if gc, but leave the same when JVM needs more memory

public class StrongReferences {

	
	public static void main(String[] args) {
		
		Integer a = new Integer(2);
		
		System.gc();
		
		a=null;
		
		//Now eligible for gc only
		System.gc();
		
		
		
	}
	
}
