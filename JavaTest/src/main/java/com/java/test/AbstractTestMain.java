package com.java.test;

import java.lang.reflect.Method;

public class AbstractTestMain extends AbstractTest {

	private static final long serialVersionUID = 1L;

	public void sound() {
		System.out.println("빈깡통이 소리는 요란하지.");
	}
	
	public void who() {
		System.out.println("나는야 ~빈깡통");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
	public void sayHello() {
		System.out.println("추상클래스 테스트이다.");
	}


	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		AbstractTestMain main = new AbstractTestMain();
		
		main.who();
		main.sound();
		main.sayHello();
		
		main.nomalMethodTest();
		main.mothodTest2();
		
		
		Class getClass1 = Class.forName("com.java.test.Child");
		
		Object object = getClass1.newInstance();
//		Field field = getClass1.getField("fieldValue");
		Method method1 = getClass1.getMethod("childSay");
		System.out.println(object);
		System.out.println(method1);
		
		
	}


}
