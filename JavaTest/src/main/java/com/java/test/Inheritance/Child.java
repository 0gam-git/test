package com.java.test.Inheritance;

public class Child extends Parent {

	public Child() {
		System.out.println("자식클래스.");
	}

	public void childSay() {
		System.out.println("안녕 .나는 자식이야.");
	}
	
	@Override
	public void override() {
		System.out.println("오버라이딩, 자식~~~~!!@자식자식!!!");
	}
	
	public void testFunc(){
		System.out.println("super~");
		super.override();
		System.out.println("super~");
	}
}
