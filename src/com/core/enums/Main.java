package com.core.enums;

public class Main {

	public static void main(String[] args) {
		MyEnum.INSTANCE1.i=10;
		System.out.println(MyEnum.INSTANCE1.i);
		System.out.println(MyEnum.INSTANCE2.i);
		
		MyEnum.INSTANCE1.j=20;
		System.out.println(MyEnum.INSTANCE1.j);
		System.out.println(MyEnum.INSTANCE2.j);
		
		
	}
}
