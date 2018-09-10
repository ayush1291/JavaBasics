package com.enums;

import com.createobjectways.MainObject;

public enum Main {
	
	// Cannot use instance as it is static
	
	INSTANCE("M"),
	INSTANCE1("M1");
	
	int i=1;
	String code;
	
	 private Main(String code) {
		/* if(this.toString()==INSTANCE.toString()){
			 
		 }*/
		 
		 this.code=code;
	}
	public static String getScore(){
		return "Hello";
	}
	
}
