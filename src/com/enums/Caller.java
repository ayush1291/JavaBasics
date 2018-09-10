package com.enums;

import java.util.ArrayList;


public class Caller {
	
	private Main statusCode;
	
	public static void main(String[] args) {
		System.out.println(Main.INSTANCE.getScore());
		second(Main.INSTANCE);
		//ACTIVE(0,"Losn  is active");
		//
	}
	
	static void second(Main main){
		Main[] mains;
		mains = Main.values();
		System.out.println(Main.valueOf("INSTANCE"));
		if(Main.INSTANCE instanceof Main){
			System.out.println("true");
		}
	}

}
