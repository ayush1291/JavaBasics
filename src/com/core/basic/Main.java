package com.core.basic;

import java.io.PrintWriter;

public class Main {
	
	final int a;
	
	public Main() {
		a=10;
	}
	
	public static void main(String[] args) {
		
		String s=null;
//		int a =null;		Cannot happen
		
//		if((null).equals("a")){
//			System.out.println("Hello");		// Not allowed
//		}
		
		 PrintWriter writer = new PrintWriter(System.out);    	//	object to characters..then characters to byte
	      writer.write("Javatpoint provides tutorials of all technology.");        
	      writer.flush(); 
//	      writer.close();										//Flush and close
	      
		//Adding integer to a string
		String str =10+10+"430"+020+20;
		System.out.println(str);
		str+=20;
		//10100
		System.out.println(str);
		
		//Adding null to a string
		str =null+"430"+10+null;
		System.out.println(str);

		str =012+32+"430"+012;					// Start with octal if start with zero and hex if oX
		System.out.println(str);
//		str =null+10+10+"430";		not allowed
		
		switchprac();
		
//		if((s).equals("a")){					// throws exception
//			System.out.println("Hello");
//		}else{
//			System.out.println("Not Null");
//		}
		
		if(null==null){				
			System.out.println("True");
		}else{
			System.out.println("False");
		}
		
		if(null instanceof Main){					// This null can point to any null object, Also, afterwards cannot be null
			System.out.println("Not null");
		}else{
			System.out.println("null");
		}
		
		
	}

	
	
	public static void switchprac(){
		// iF no default, nothing happens
		
		// the order in which cases are written do not matter
		
		switch(1){
		
			case 2: System.out.println("2");
		
			case 3: System.out.println("3");
			
			default : System.out.println("default");
			
			case 1: System.out.println("1");
		}
		
		
		
		
	}
}
