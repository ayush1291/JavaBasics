package com.multithreading.waitnotifynotifyall.notworking;

public class Product{
    String name;
    
    Product(String name){
        this.name = name;
    }
    
    void setName(String name){
        this.name = name;
    }
    
    String getName(){
     return this.name;   
    }
    
    public String toString(){//
        return "Product is --" + name;
    }
}