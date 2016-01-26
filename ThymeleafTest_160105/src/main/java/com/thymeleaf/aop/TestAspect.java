package com.thymeleaf.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//service 단계  controller -> service -> date Access object

@Aspect  //Aspect는 어드바이스 + 포인트컷이다.
public class TestAspect {

	//Before 어떤 시점에    //execution 이 함수가 실행되기 전에 .
	@Before(value="execution(* com.thymeleaf.aop.TestMain.*(..))")
	public void before1(){
		System.out.println("before===============");
	}
	
	@After(value="execution(* com.thymeleaf.aop.TestMain.*(..))")
	public void after1(){
		System.out.println("after===============");
	}
}
