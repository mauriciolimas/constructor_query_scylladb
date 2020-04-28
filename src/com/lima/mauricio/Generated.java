package com.lima.mauricio;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Generated {

	public Set<String> generatedValues(int numberItems) {
		Set<String> list = new HashSet<String>();
		
		for(int i=0; i<numberItems; i++) {
			list.add(String.valueOf(Math.random() * 100));
		}

		return list;
	}

	public List<String> generatedListValues(int numberItems) {
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<numberItems; i++) {
			list.add(String.valueOf(Math.random() * 100));
		}

		return list;
	}
}
