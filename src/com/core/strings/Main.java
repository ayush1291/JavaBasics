package com.core.strings;

public class Main {

	public static void main(String[] args) {
		String a ="abc";
		String b ="abc";
		System.out.println(a==b);
		
		Sample sample = new Sample();
		sample.a=20;
		Integer b1=40;
		System.out.println(sample);
		second(sample,b1);
		System.out.println(sample.a+" "+b1);
	}
	
	public static void second(Sample sample, Integer b){
		System.out.println(sample);
		b=50;
		sample = new Sample();
		sample.a=30;
	}
	
}
