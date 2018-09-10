package com.createobjectways;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class One {

	public static void main(String[] args) {
		MainObject object = new MainObject(2,1);
		
		
	// Method 2
		try {
			// Class.forName actually loads the Class in Java but doesn’t create any Object
			Class cls = Class.forName("com.createobjectways.MainObject");  // Should have public default constructor
			 MainObject obj =(MainObject) cls.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Method 3 -- see the use of protected method clone
		try {
			MainObject object2 = (MainObject)object.clone();
			if(object == object2) System.out.println("Same");
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		
		//Method 4- deserialise
		
		//Method 5 Reflection
		Constructor<MainObject> constructor;
		try {
			constructor = MainObject.class.getConstructor(new Class[]{Integer.TYPE, Integer.class});
			MainObject r = constructor.newInstance(2,3);
			
			constructor = MainObject.class.getConstructor();
			MainObject r1 = constructor.newInstance();
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
