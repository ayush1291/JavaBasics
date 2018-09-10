package designPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Functional Interfaces
public class Strategic {

	
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(4);
		Comparator comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer s1, Integer s2) {
				if(s1>s2) return -1;
				else return 1;
			}
		};
		
		list = sort(list, comp);
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i)+" ");
		}
		
	}
	
	
	public static List sort(List list, Comparator<Object> comp){
		Object[] objs = list.toArray();
		
		for(int i=0; i<list.size(); i++){
			for(int j=i+1; j<list.size(); j++){
				if(comp.compare(objs[i], objs[j])<0){
					Object temp = objs[i];
					objs[i]=objs[j];
					objs[j]=temp;
				}
			}
		}
		for(int i=0; i<list.size(); i++){
			System.out.println(objs[i]+" ");
		}
		return Arrays.asList(objs);
	}
	
	
	
	
	
	public static interface Comparator<T> {
		public int compare(T s1, T s2);
	}

}
