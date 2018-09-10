package com.head.ooad.chap1;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	
	List<Guitar> lists = new ArrayList<>();
	
	
	public void add(int model, GuitarSpec spec){
		Guitar guitar = new Guitar(model,spec);
		lists.add(guitar);
	}
	
	
	public Guitar search(Guitar searchGuitar) {
		
		for(Guitar guitar:lists){
			if(searchGuitar.search(guitar)!=null) return guitar;
		}
		return null;
		
	}
	
	

}
