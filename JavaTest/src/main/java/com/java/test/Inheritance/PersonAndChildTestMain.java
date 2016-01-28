package com.java.test.Inheritance;

public class PersonAndChildTestMain {

	public PersonAndChildTestMain() {
	}

	public static void main(String[] args) {
		Child c = new Child();

		c.childSay();
		c.parentSay();
		
		System.out.println("=============");
		Parent p = new Parent();
		p.override();
		c.testFunc(); //super
		
		Parent p1 = new Child();
		p1.override();
		System.out.println("=============");
		
	}

}
