package com.java.test;

public class Parent {

	public Parent() {
		System.out.println("부모클래스.");
	}

	public void parentSay() {
		System.out.println( "안녕. 난 부모야");
	}
	
	public void override()
	{
		System.out.println("오버라이딩, 부모");
	}
}
