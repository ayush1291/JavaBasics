package com.core.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MySingletonBreaker {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		MySingletonClass mySingletonClass = MySingletonClass.getInstance();
		mySingletonClass.setI(8);
		
		MySingletonClass mySingletonClass2 = MySingletonClass.getInstance();
		
		System.out.println(mySingletonClass.getI());
		System.out.println(mySingletonClass2.getI());
		
		Constructor[] cons = MySingletonClass.class.getDeclaredConstructors();
		
		for(Constructor con :cons){
			con.setAccessible(true);		// changed for the constructor instance
			mySingletonClass2 = (MySingletonClass) con.newInstance();
		}
		System.out.println(mySingletonClass2.getI());
		
	}
}
