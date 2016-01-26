package com.java.test.computerbooting;

public class OpenClosePrincipleTestMain {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		OpenClosePrinciple lg = new LGKeyboardImpl();
		lg.connectKeyboard();

		Temp t = new Temp();
		t.showText();

		Temp t2 = (Temp) Class.forName("com.java.test.computerbooting.Temp").newInstance();
		t2.showText();
		
//		Class<?> t4 = Class.forName("com.java.test.computerbooting.Temp").newInstance();

		Class<?> cls = Class.forName("com.java.test.computerbooting.Temp");
		Object ob = cls.newInstance();
		Temp t3 = (Temp) ob;
		t3.showText();
	}
}

class Temp {
	public void showText() {
		System.out.println("하이");
	}
	
	private String argName;
	
	public void setArgName(String argName){
		this.argName = argName;
	}
	private OpenClosePrinciple ocp;
	
	public void test(){
	    	if(argName.equals("삼성")){
	    		ocp = new SamsungKeyboardImpl();
	    	}
	    	else if(argName.equals("LG")){
	    		ocp = new LGKeyboardImpl();
	    	}
	    }

}
