package com.cloning;

import java.util.HashMap;
import java.util.HashSet;

public class Child implements Cloneable {

	int i;
	HashMap<Integer, Integer> map;

	public Object clone() throws CloneNotSupportedException {

		
		Child clone = null;
		try {
			clone = (Child) super.clone();
			clone.map= (HashMap<Integer, Integer>) this.map.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e); // won't happen } return clone;
		}
		
		return clone;
	}

}
