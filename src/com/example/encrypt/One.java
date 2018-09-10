package com.example.encrypt;

public class One {
	static String[] a = {"a","cc","ee","bb"};
	
	
	public static void main(String[] args) {
		
		int a=11000011;
		
		byte a1=(byte)a;
		int a2=(int)a1;
		System.out.println(a1);
		
		
		
		/*System.out.println("a".compareTo("b"));
	
		for(int i=0 ; i<a.length; i++){
			insert(i);
		}
		for(int i=0 ; i<a.length; i++){
			System.out.println(a[i]);
		}
		*/
		
		
	}
	public static void insert(int pos){
		if(pos==1){
			return;
		}
		while(pos>0){
			if(a[pos].compareToIgnoreCase(a[pos-1])<0){
				String temp = a[pos];
				a[pos]= a[pos-1];
				a[pos-1]=temp;
				pos--;
			}else{
				break;
			}
		}
		
	}

}
