package com.core.forEachLoop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//	For each loop works for any collection object or array

//  eliminates  the possibility of bugs and makes the code more readable

// Only works if class implements iterable interface and the overriden method returns the iterator, else null pointer exception

public class Main {

	
	public static void main(String[] args) {
		
		MyIterable<String> array = new MyIterable<String>();
		
		String[] array2 = new String[]{
				"1","2"
		};
		
		for (String string : array2) {
			System.out.println("string");
		}
		
		for (String string : array) {
			System.out.println("string");
		}
		
	}
	
	public static class MyIterable<String> implements Iterable<String>{
		
		List<String> array = new ArrayList<String>();
		
		@Override
		public Iterator<String> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
	}
}
