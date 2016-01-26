package com.thymeleaf.model;

public class unitTest {

	// public String test(String str){
	// return str;
	// }

	public unitTest(String a) {
		System.out.println(a);
	}
	private String str = null;
	
	public void setTest(final String str) {
		this.str = str;
	}
	
	public String getTest(){
		return str;
	}
}
