package com.webcomrades.demo.model;



public class Currency {

	public String lhs;
	public String rhs;
	
	public Currency() {
		
	}

	@Override
	public String toString() {
		return lhs + " is " + rhs;
	}

}
