package com.multithreading.singleton_volatile_final_doublecheck.way4;
public class Singleton{
    
    //way3
    //best of all
	//this is better than 3 but issue of double check locking
	// this is resolved by volatile
	// volatile is used to perform only one atomic operation at a time for any number of threads
	// this issue is also resolved by final
	
	// Locking object can never be null
	// 
	
    private static volatile Singleton singleton = null;
    private static Object mutex = new Object();
    
    public static void main(String[] args) {
    	getInstance();
	}
    
    private Singleton(){
    	
    }
    
    public static Singleton getInstance(){
    
    	if(singleton==null){
    		System.out.println(" Read as null");
    		synchronized(mutex){
    	         if(singleton == null){
    	            singleton = new Singleton();
    	            }   
    	        }
    	}
        return singleton;
    }
}