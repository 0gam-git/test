package com.java.test.Inheritance;

public class InterfaceTestMain implements InterfaceTest{

	@Override
	public void ChannelDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ChannelUp() {
		// TODO Auto-generated method stub
		
	}

	public void add()  //필요한 부분을 공통적으로 쓰고, 변화하는 부분을 그 impl에서 추가해서 사용한다.
	{
		System.out.println("fgfgfg");
	}
	
}
