package com.java.test.Inheritance;

import java.awt.*;

public class InheritanceTest {

	public InheritanceTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Child c = new Child();

		c.childSay();
		c.parentSay();
		
		System.out.println("=============");
		Parent p = new Parent();
		p.override();
		c.testFunc();
		
		Parent p1 = new Child();
		p1.override();
		System.out.println("=============");
		
//		Frame m = new Frame();
//		m.setSize(200, 200);
//		m.show();
	}

}
