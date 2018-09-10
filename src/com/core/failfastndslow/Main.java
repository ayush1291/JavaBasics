package com.core.failfastndslow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	// fail-fast iterator - Vector, ArrayList, HashSet
	// fail safe - ConcurrentHashMap - has mod and expected mod count to check
	// the iterator gives new object to entry part 
	// main difference betweren a hashmap and concurrent hashmap is that in failfast, it returns the reference
	// in fail safe it returns new object
	
	public static void main(String[] args) {
		
		Map<String, String> hashMap =  new HashMap<>();
		hashMap.put("A","AA");
		hashMap.put("B","BB");
		
		Iterator<Entry<String, String>> hItr = hashMap.entrySet().iterator();
		while (hItr.hasNext()) {
			   Entry entry = hItr.next();
			   System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
//			 will throw CMException
//			     hashMap.put("C", "CC");
			   hItr.remove();
		}
		Sample sample = new Sample();
		sample.i=10;
		Map<String, Sample> concurrentHashMap =  new ConcurrentHashMap<>();
		
		concurrentHashMap.put("A",sample);
//		concurrentHashMap.put("B","BB");
		//////TBD
		Iterator<Entry<String, Sample>> cItr = concurrentHashMap.entrySet().iterator();
		while (cItr.hasNext()) {
			   Entry entry = cItr.next();
			 //will throw CMException
//			   Sample sample1 = new Sample();
			   sample = new Sample();
			   concurrentHashMap.remove("A",sample);
			   cItr.remove();
			   System.out.println("key: " + entry.getKey() + " value: " + ((Sample)entry.getValue()).i);
		}

	}
	
	
	public static class Sample{
		public int i=2;
		
	}
}
