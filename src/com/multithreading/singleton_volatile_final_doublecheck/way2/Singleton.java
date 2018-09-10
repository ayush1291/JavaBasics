package com.multithreading.singleton_volatile_final_doublecheck.way2;
public class Singleton{
    
    //way2
    //Slow performance and unnecessary synchronization that is not required once the instance variable is initialized.
    private static Singleton singleton = null;
    
    private Singleton(){
    }
    
    synchronized public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}