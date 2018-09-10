package com.cloning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Parent {

	public static void main(String[] args) {
		
		Child c1 = new Child();
		c1.i=4;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(1, 2);
		c1.map=map;
		
		ArrayList<Child> childLists = new ArrayList<>();
		ArrayList<Child> copy = new ArrayList<>(childLists);
		
		childLists.add(c1);
		
		ArrayList<Child> copy = new ArrayList<Child>(childLists.size());
		Iterator<Child> iterator = childLists.iterator();
		while (iterator.hasNext()) {
			try {
				copy.add((Child) iterator.next().clone());
			} catch (CloneNotSupportedException e) {
			}
		}
		
		Child tc1 = childLists.get(0);
		tc1.i=10;
		tc1.map.put(2, 34);
		Child c2 = copy.get(0);
		
		System.out.println(c2.i);
		System.out.println(c2.map.size());
		
	}
	
}
