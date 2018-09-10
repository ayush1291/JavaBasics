package com.core.enums;

public enum MyEnum {

	INSTANCE1(5), INSTANCE2;
	
	private MyEnum() {						// Only private constructor is permitted
	}
	
	private MyEnum(int a) {						// Only private constructor is permitted
	}
	
	int i=2;
	static int j=3;
	
	public void start(){
		System.out.println("Start");
	}
}
