package com.references.objectpool;

import java.util.LinkedList;

public abstract class ObjectPool<T> {
	
	
	public static void main(String[] args) {
		P p = new C();
		p.add();
	}
	
	static class P{
		public static void add(){
			System.out.println("P");
		}
	}
	
	static class C extends P{
		
		public void add(){
			System.out.println("C");
		}
	}
	
	public ObjectPool() {
//		used = new LinkedList<>();
		
	}
	
	abstract T create();
	abstract void destroy(T t);
	
	

	static class Node<T> {
		T val;
		long time;
		
		public Node(T t, long time) {
			this.val=t;
			this.time=time;
		}

	}
	

}
