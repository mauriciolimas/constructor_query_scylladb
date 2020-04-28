package com.lima.mauricio;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstructorQuery {

	private String prefixQuery = "SELECT * FROM [";
	private String suffixQuery = "]";
	private Set<String> params;
	private int quantity = 100;
	private Set<String> queries;

	public ConstructorQuery() {
		queries = new HashSet<String>();
	}

	public static ConstructorQuery builder() {
		return new ConstructorQuery();
	}

	public ConstructorQuery addPrefixQuery(String prefixQuery) {
		this.prefixQuery = prefixQuery;
		return this;
	}

	public ConstructorQuery addSuffixQuery(String suffixQuery) {
		this.suffixQuery = suffixQuery;
		return this;
	}

	public ConstructorQuery addParams(Set<String> params) {
		this.params = params;
		return this;
	}

	public ConstructorQuery addParams(List<String> params) {
		this.params = new HashSet<String>(params);
		return this;
	}

	public ConstructorQuery addQuantityParams(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public Set<String> build() {
		constructQueryWithArguments();
		return queries;
	}

	private String addSuffix(String s) {
		return String.format("%s %s", s.substring(0, s.lastIndexOf(",")), suffixQuery);
	}

	private void setQuerie(String query) {
		queries.add(addSuffix(query));
	}

	private String concat(String temp, String param) {
		return String.format("%s '%s',", temp, param);
	}

	private void constructQueryWithArguments() {

		String temp = prefixQuery;
		int control = 0;

		for (String s : params) {

			if (control == quantity) {
				setQuerie(temp);
				temp = prefixQuery;
				control = 0;
			}
			temp = concat(temp, s);
			control++;
		}

		setQuerie(temp);
	}
}
