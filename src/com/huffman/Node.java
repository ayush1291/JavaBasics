package com.huffman;

import java.util.PriorityQueue;

public class Node implements Comparable<Node>{
	int number;
	int freq;
	boolean isExtra;
	Node left, right;
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public Node(int number,int freq, boolean isExtra){
		this.number=number;
		this.freq=freq;
		this.isExtra=isExtra;
	}
	
	@Override
	public int compareTo(Node arg0) {
		
		if(arg0.freq<this.freq)
			return 1;
		else if(arg0.freq>this.freq)
			return -1;
		else
			return 0;
	}
}
