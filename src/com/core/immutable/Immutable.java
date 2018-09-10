package com.core.immutable;
public class Immutable{
	
    public static void main(String[] args) {
    	Integer i = 10;
    	getBack(i);
    	System.out.println(i);
	}
    
    public static Integer getBack(Integer i){
    	i++;
    	return i;
    }
    
    private Immutable(){
    }
  
}