package com.core.mapoerformance;

import java.util.Map;

public class WorkerThread extends Thread{
	private Map<String, Integer> map = null;
	private String name;
    public WorkerThread(Map<String, Integer> assignedMap, String name) {
    	this.name=name;
          this.map = assignedMap;
    }
    @Override
    public void run() {
          for (int i=0; i<500000; i++) {
                 // Return 2 integers between 1-1000000 inclusive
                 Integer newInteger1 = (int) Math.ceil(Math.random() * 1000000);
                 Integer newInteger2 = (int) Math.ceil(Math.random() * 1000000);
                 
//                 System.out.println("Get " +name+" "+ newInteger1);
                 // 1. Attempt to retrieve a random Integer element
                 Integer retrievedInteger = map.get(String.valueOf(newInteger1));
                 // 2. Attempt to insert a random Integer element
                 
//                 System.out.println("Post " +name+" "+ newInteger2);
                 map.put(String.valueOf(newInteger2), newInteger2);                
          }
    }
}
