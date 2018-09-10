package com.collections.map;

import java.util.HashMap;

///?Default cap is 16 and load factor is 0.75
//Key is null, then hash function giviing code  is zero
//Map uses array(as buckets) of Nodes to store each element
// compares first the key hashcode(got from hash function) and then compares the equals

//Map is actually an array of nodes (key,value,next,hash (hash = hashcode ^ (hashcode >>> 16)))
//bucket logic : hash & (capacity of the map - 1)
/*if(NOT found ath at bucket){
	simply add new node at teh bucket position
  }
 else{
 	compare hash and then key at the already present node to new key being added
 	if(same)
 		replace value
 	else
 		iterate till u get eligible node and then add new node or replace value
 }

*/
public class MyMap {

	
	public static void main(String[] args) {
		
//		HashMap<K, V>map
		
		mapHashAssign();
		
	}
	
	
	
	//bucket pick logic
	static void mapHashAssign(){
		
		int h=29012892;
		Integer key =2147483647;
		int size =16;
		System.out.println(Integer.toBinaryString(h >> 16));
		h = key.hashCode() ;
		
		int buc = h & 31;
		System.out.println(h);
		System.out.println(buc);
	}
}
