package com.multithreading.singleton_volatile_final_doublecheck.way1;
public class Singleton{
    
    //way1
    //bt early creation is not req always + no params can be passed
	
    private static Singleton singleton = new Singleton();
    
    private Singleton(){
    }
    
    public static Singleton getInstance(){
        return singleton;
    }
    
}