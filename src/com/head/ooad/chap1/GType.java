package com.head.ooad.chap1;

public enum GType {
	
	AB("ab"),AB1("ab1"),AB2("ab2");
	String str;
	
	GType(String str){
		this.str=str;
	}
	
	public String toString() {
		
		 return str;
	};

}
