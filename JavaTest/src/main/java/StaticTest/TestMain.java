package StaticTest;

public class TestMain {

	
	public TestMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		String a = TestStatic.abc + "dfgdfg123";
		System.out.println(TestStatic.abc);
		System.out.println(a);
		
		TestStatic ts = new TestStatic();
		String tsStr = ts.abc;
		
		System.out.println("==="+tsStr);
		
	}
}
