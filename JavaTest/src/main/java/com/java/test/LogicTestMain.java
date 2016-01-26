package com.java.test;

public class LogicTestMain extends InheritanceTest2  implements InheritanceAndInterfaceTest {

	@Override
	public void Test() {
		System.out.println("인터페이스 구현부, 변경이 많다.");
	}

	@Override
	public void Test2() {
		System.out.println("인터페이스 구현부2, 변경이 많다.");
	}

	@Override
	public void say() {
		super.say();
		System.out.println("상속1");
	}
	
	@Override
	public void eat() {
		System.out.println("상속2");
//		super.eat();
	}
	
	
	public static void main(String[] args) {
		LogicTestMain main = new LogicTestMain();
		main.say();
		main.eat();
		main.Test();
		main.Test2();
		
	}
}
