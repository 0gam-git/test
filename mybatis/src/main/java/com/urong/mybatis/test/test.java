package com.urong.mybatis.test;

public class test {

 	public void show(String cmd){
        if ( cmd.equals("Test")){
            System.out.println("cmd is Test");
        }
    }
   
    public void show2(String cmd){
        if( "Test".equals(cmd)) {
            System.out.println("cmd is Test");
        }
    }

	public static void main(String[] args) {
		test t = new test();
		String cmd = null;
		
		t.show(cmd);
//		t.show2(cmd);
	}
}
