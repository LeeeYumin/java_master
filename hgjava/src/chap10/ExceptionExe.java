package chap10;

public class ExceptionExe {
	public static void main(String[] args) {
		test();
		System.out.println("end of prog");
	}

	public static void test() {
		// 일반예외 : 에러 시점에 예외 처리.
		try {
			Class.forName("java.lang.String"); // class 이름의 클래스의 forName 이라는 메소드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

} // end of class
