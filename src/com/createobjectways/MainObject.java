package com.createobjectways;

public class MainObject implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	public MainObject() {
		System.out.println("Default constructor is called");
	}
	
	public MainObject(int a, Integer b) {
		
		System.out.println("Constructor is called");
	}
	
}
