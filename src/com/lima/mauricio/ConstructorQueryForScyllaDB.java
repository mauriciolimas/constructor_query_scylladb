package com.lima.mauricio;
import java.util.List;
import java.util.Set;

public class ConstructorQueryForScyllaDB {


	public static void main(String[] args) {

		int NUMBER_PARAMS = 1147; 
		
		Set<String> values0 = new Generated().generatedValues(NUMBER_PARAMS);
		List<String> values1 = new Generated().generatedListValues(NUMBER_PARAMS);
		
		Set<String> listQueries0 = ConstructorQuery
					.builder()
					.addParams(values0)
					.addPrefixQuery("SELECT * FROM TABLE [")
					.addSuffixQuery("]")
					.build(); 
		
		Set<String> listQueries1  = ConstructorQuery
				.builder()
				.addParams(values1)
				.addPrefixQuery("INSERT INTO TABLE [")
				.addSuffixQuery("]")
				.build(); 
		
		
		listQueries0.forEach(e -> System.out.println(e));
		listQueries1.forEach(e -> System.out.println(e));
		
	}

}
