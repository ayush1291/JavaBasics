package com.core.circularandflow;

public class Lift {
	IMain main;
	
	public Lift(Main main,String val) {
		this.main= main;
		System.out.println(main.i);
		main.i=3;
		System.out.println(val);
		
	}
}
