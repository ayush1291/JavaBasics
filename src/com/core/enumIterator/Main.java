package com.core.enumIterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Iterator has a remove method, but enumeration does not have it....

// Enumeration is a legacy class

// Working of an iterator

public class Main {

	public static void main(String[] args) {
		
		List<String> array = new ArrayList<String>();
		Set<String> array2 = new HashSet<String>();
		
		array.add("1");
		array.add("2");
		
		array2.add("1");
		array2.add("2");
		
		Iterator itr = array.iterator();
		while(itr.hasNext()){
			itr.next();
			itr.remove();
		}
		
		
		Iterator itr2 = array2.iterator();
		while(itr2.hasNext()){
			itr2.next();
			itr2.remove();
		}
		
		System.out.println(array.size());
		System.out.println(array2.size());
	}
	
}
