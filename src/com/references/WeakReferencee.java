package com.references;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

//This is marked for gc, if it has only weak reference pointing

public class WeakReferencee {
	
	public static void main(String[] args) {
		Integer a = new Integer(3);
		WeakReference<Integer> weak = new WeakReference(a);
		System.gc();
		
		//Here, it holds a string ref
		System.out.println(weak.get());
		
		//String ref is removed
		a=null;
		System.gc();
		System.out.println(weak.get());
		
		//A use case is to hava a user meta data, where, for eg DbConnection data is stored
		// along with user meta data
		Integer a1 = new Integer(2);
		Integer a2 = new Integer(3);
		Map<Integer, String> map = new WeakHashMap<>();
		map.put(a1, "Stored by a1");
		map.put(a2,"Stored by a2");
		System.out.println(map);
		//Clearing a1- so, only weak ref to it
		a1=null;
		System.gc();
		System.out.println(map);
		
		//Do check how weap hash map is implemented
		
	}

}
