package chap10;

public class ArrayExceptionExe {
	public static void main(String[] args) {

		// 배열의 범위를 벗어난 위치에 값 참조.
		int[] numAry = { 2, 5, 7 };
		try {
			for (int i = 0; i <= 3; i++) { // 4번째 값은 없어서 7까지만 콘솔창에 찍힘
				System.out.println(numAry[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("범위의 값을 벗어남");
		}
		System.out.println("end of prog");
	}
} // end of class
