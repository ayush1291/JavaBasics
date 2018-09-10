package com.core.singleton;

public class MySingletonClass {

	private static MySingletonClass mySingletonClass;
	
	private int i=2;
	
	private MySingletonClass() {
		System.out.println("This is private constructor");
		// TODO Auto-generated constructor stub
	}
	
	
	public int getI() {
		return i;
	}



	public void setI(int i) {
		this.i = i;
	}



	public static MySingletonClass getInstance(){
		
		if(mySingletonClass==null){
			mySingletonClass = new MySingletonClass();
			return mySingletonClass;
		}else{
			return mySingletonClass;
		}
	}
	
}
