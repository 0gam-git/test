package com.java.test;

public class JavaTest extends LogicTestMain{
	private static int sint = 1;
	
	static {
		sint = 111; //전체 공유 , 바꾸는 족족 바뀐다.
		System.out.println("sint == "+sint);
	}
	
	public JavaTest() {
		//new와 동시에( 메모리에 올라가자마자 ) 가장 먼저 실행된다.
		// 리턴 값이 없고, 디폴트와 파라미터 둘다 사용할 수 있다
	}

	private String b;
	private int a;
		
	public JavaTest(int a , String b)
	{
		this.a = a;
		this.b = b;
	}
	
	public static void main(String[] args) {
		
		//sint = 0;
		JavaTest java = new JavaTest();
		java.sint = 1;
		System.out.println("0 sint == "+ java.sint);
		
		System.out.println("a=="+ java.a);
		System.out.println("b=="+ java.b);
		JavaTest j = new JavaTest(1, "dfgdg");
		
		System.out.println("j.a == "+ j.a);
		System.out.println("j.b == "+ j.b);
		
		java.say();
		java.Test2();
	}
}
