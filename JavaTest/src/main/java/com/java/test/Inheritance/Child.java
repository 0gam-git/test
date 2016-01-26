package com.java.test.Inheritance;

public class Child extends Parent {

	private String fieldValue;
	
	public Child() {
		System.out.println("자식클래스.");
		fieldValue = "123e";
	}

	public void childSay() {
		System.out.println("안녕 .나는 자식이야.");
	}
	
	@Override
	public void override() {
		System.out.println("오버라이딩, 자식656757657657");
	}
	
	public void testFunc(){
		System.out.println("super~");
		super.override();
		System.out.println("super~");
	}
}
