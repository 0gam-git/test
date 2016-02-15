package StaticTest;

public class TestMain {

	
	public TestMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		String a = TestStatic.abc + "dfgdfg123";
		System.out.println(TestStatic.abc);
		System.out.println(a);
		
		String tsStr = TestStatic.abc;
		
		System.out.println("==="+tsStr);
		
	}
}
