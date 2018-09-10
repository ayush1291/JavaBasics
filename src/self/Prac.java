package self;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Prac {
	
	
	
	public static void main(String[] args) {
		
		
		
	}
	
	static class A 
	{
		static{
			System.out.println("Static");
		}
		
		{
			System.out.println("Hi");
			
		}
		
	    int i;
	    
	    public A() {
	    	System.out.println("Constructor");
		}
	     
	    // parameterized constructor
	    
	    
	    public A(int i) 
	    {
	        this.i = i;
	    }
	     
	}
	 
	// subclass B 
	// B class doesn't implement Serializable
	// interface.
	static class B extends A implements Serializable
	{
	    int j;
	    public B() {
	    	super(9);
	    	System.out.println("B const");
		}
	    
	    // parameterized constructor
	    public B(int j) 
	    {
	    	super(9);
	        this.j = j;
	    }
	}
	 
	// Driver class
	static public class Test
	{
		
	    public static void main(String[] args)  throws Exception 
	    {
//	    	A a = new A();
	    	
	        B b1 = new B(20);
	         
	        System.out.println("j = " + b1.j);
	         
	         
	        //Saving of object in a file
	        FileOutputStream fos = new FileOutputStream("abc.ser");
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	             
	        // Method for serialization of B's class object
	        oos.writeObject(b1);
	             
	        // closing streams
	        oos.close();
	        fos.close();
	             
	        System.out.println("Object has been serialized");
	         
	         
	        // Reading the object from a file
	        FileInputStream fis = new FileInputStream("abc.ser");
	        ObjectInputStream ois = new ObjectInputStream(fis);
	             
	        // Method for de-serialization of B's class object
	        B b2 = (B)ois.readObject();
	             
	        // closing streams
	        ois.close();
	        fis.close();
	             
	        System.out.println("Object has been deserialized");
	         
	        System.out.println("j = " + b2.j);
	    }
	}
	
	
}
