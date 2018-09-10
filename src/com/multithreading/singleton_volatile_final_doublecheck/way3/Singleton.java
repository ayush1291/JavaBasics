package com.multithreading.singleton_volatile_final_doublecheck.way3;
public class Singleton{
    
    //way3
    //best of all
	//this is better than 2
	
	
    private static Singleton singleton = null;
    private static Object mutex = new Object();
    private Singleton(){
    }
    
    public static Singleton getInstance(){
        //synchronized(Singleton.class){
            //or 
        synchronized(mutex){
         if(singleton == null){
            singleton = new Singleton();
            }   
        }
        return singleton;
    }
}