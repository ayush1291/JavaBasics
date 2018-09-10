package com.head.ooad.chap1;

public class GuitarSpec {

	public GType type;
	public int strings;
	public String brand;
	
	public GuitarSpec(GType type, String brand, int strings) {
	this.type=type;
	this.brand=brand;
	this.strings=strings;
	}
	
	public int getStrings() {
		return strings;
	}

	public void setStrings(int strings) {
		this.strings = strings;
	}

	public GType getType() {
		return type;
	}
	
	public void setType(GType type) {
		this.type = type;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
