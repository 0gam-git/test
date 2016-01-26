package com.java.test.abstractclass;

import java.lang.reflect.Method;

public class AbstractTestMain extends AbstractTest {

	@Override
	public void sound() {
		System.out.println("빈깡통이 소리는 요란하지. 창창창창캉캉캉캉");
	}
	
	@Override
	public void who() {
		System.out.println("나는야 ~빈깡통");
	}
	
	@Override
	public void test() {
		System.out.println("test!");
	}

	public AbstractTestMain() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		AbstractTestMain m = new AbstractTestMain();
		
		m.test();
		m.who();
		m.sound();
		System.out.println("===============");
		m.nomalMethodTest();
		m.mothodTest2();
		
	}
}
