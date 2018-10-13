package com.references;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//The soft reference class is used to create a soft reference to an existing object 
//that is already referred to by a strong reference. 
//The actual object on the heap that is being referred to is called the referent.



public class SoftReferences {
	
	//Here, in total 2 strong references are created and softref internally holds a soft ref to object
	public static void main(String[] args) throws InterruptedException {
		Integer a = new Integer(3);
		SoftReference<Integer> soft = new SoftReference<Integer>(a);
		a=null;
		System.gc();
		
		//Even though gc is called, only when jvm wants memory, then only this is useful
		System.out.println(soft.get());
		
		//Here, again a strong ref is established, now even if jvm wants mem, will not destroy this
		Integer b = soft.get();
		
		
		//Sample to see when jvm wants memory, it will clear this
		b=null;
		List<Integer[]> list = new ArrayList<>();
//		WeakReference<Integer> weak = new WeakReference<>(soft.get());
		while(true){
			list.add(new Integer[10000]);
			System.out.println(soft.get());
			System.gc();
		}
		
		//An eg where it can be used is object pools
		
	}
	
}
