package StaticTest;

final class TestStatic {

	public static String abc = "static";
	
	private static TestStatic t = null;
	
	private TestStatic() {
		// TODO Auto-generated constructor stub
	}
	public static TestStatic getInstance(){
		if(t == null){
			t = new TestStatic();
		}
		return t;
	}
	
	
}
