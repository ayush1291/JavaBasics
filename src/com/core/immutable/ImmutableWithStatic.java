package com.core.immutable;

public class ImmutableWithStatic {
	// Integer or int dows not make any diff
	
	
	static Integer i = 10;
	
	   public static void main(String[] args) {
	    	getBack(i);
	    	System.out.println(i.toString());
	    	i++;
	    	System.out.println(i.toString());
	    	i++;
	    	
	    	new Second(i); 
	    	System.out.println(i);
		}
	    
	    public static Integer getBack(Integer i){
	    	i=i+1;
	    	return i;
	    }
	    
	    public static class Second{
	    	
	    	public Second(Integer i) {
	    		i++;
				// TODO Auto-generated constructor stub
			}
	    }
}
