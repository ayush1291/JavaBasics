package com.head.ooad.chap1;

public class Chap1 {

	public static void main(String[] args) {
		
		Inventory inventory = new Inventory();
		add(inventory);
		
		System.out.println("Customer came");
		System.out.println("Asked for "+1+"ab"+"zX");
		
		Guitar guitar = inventory.search(new Guitar(0, new GuitarSpec(GType.AB, "zx")));
		if(guitar!=null){
			System.out.println("Found");
		}else{
			System.out.println("Not available");
		}
		
	}
	
	public static void add(Inventory inventory){
		inventory.add(1, new GuitarSpec(GType.AB, "zx"));
//		inventory.add(2, "ab1", "zx1");
//		inventory.add(3, "ab2", "zx2");
//		inventory.add(4, "ab", "zx3");
	}
	
}
