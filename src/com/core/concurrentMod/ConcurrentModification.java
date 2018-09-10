package com.core.concurrentMod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

//Try both execute and iterator
// Check the difference in iterator.remove and list.remove
//how does the memory restructure when any element is removed
//All collections are iterable and only they can work in foreach loop
//for each loop uses iterator internally
// diff in modcount and expectedmod count causes the CMexception

public class ConcurrentModification {
	List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		ConcurrentModification concurrentModification = new ConcurrentModification();
//		concurrentModification.execute();
		concurrentModification.map();
		
	}
	
	public void iterator(){
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		Iterator<Integer> iterator = list.iterator();
//		 iterator.remove();
		
		while(iterator.hasNext()){
			System.out.println("Removing "+iterator.next());
			iterator.remove();
			iterator.remove();
		}
		
	}

	private void map(){
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 1);
		map.put(4, 1);
		
		Iterator<Entry<Integer, Integer>> iterator= map.entrySet().iterator();
		
		while(iterator.hasNext()){
			iterator.next();
			map.remove(1);
		}
		for(int i=0; i<map.size(); i++){
			map.put(6, 1);
			map.get(1);
//			map.remove(1);
		}
	}
	
	private void execute() {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			iterator.next();
			list.remove(1);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Removing "+(list.size()-1));
			list.remove(list.size()-1);
		}
		
		
		
		for (Integer integer : list) {
			System.out.println("Removing "+(list.size()-1));
			list.remove(list.size()-1);
			
		}
		
		
		
	}
	
	
}
