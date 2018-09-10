package com.huffman;

import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {
	
	public static void main(String[] args) {
		
		
		
		
		
		Node node = new Node();
		node.freq=10;
		node.number=1;
		
		Node node1 = new Node();
		node1.freq=9;
		node1.number=2;
		
		Node node2 = new Node();
		node2.freq=8;
		node2.number=3;
		
		Node node3 = new Node();
		node3.freq=2;
		node3.number=4;
		
		Node node4 = new Node();
		node4.freq=1;
		node4.number=5;
		
		Queue<Node> nodes = new PriorityQueue<Node>();
		nodes.add(node);
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		
		setHuffManCodes(nodes);
		
		
	}
	
	public static void printCodes(Node top,String str){
		if(top==null){
			return;
		}
		
		if(!top.isExtra){
			System.out.println(top.number + " "+top.freq+" "+str);
		}
		
		printCodes(top.left, str+"0");
		printCodes(top.right, str+"1");
		
	}
	
	public static void setHuffManCodes(Queue<Node> nodes){
		Node top,left, right;
		
		while(nodes.size()!=1){
			left = nodes.poll();
			right = nodes.poll();
			
			top = new Node(0,left.freq+right.freq,true);
			top.left=left;
			top.right=right;
			nodes.add(top);
		}
		printCodes(nodes.poll(),"");
		
	}

}
