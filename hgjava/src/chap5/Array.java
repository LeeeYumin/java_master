package chap5;

public class Array {
	public static void main(String[] args) {
		int a = 10;
		int[] ary = {10, 20, 33, 25, 34}; //선언하면서 배열을 담는 방식
		int sum = 0;
//		sum = ary[0] + ary[1] + ary[2]; //배열값 가져와서 합계 구하는 식. 많아지면 반복문 사용.
		for(int i=0; i < ary.length; i++) {
			sum = sum + ary[i];
		}
		System.out.println("합계는 " + sum + "입니다.");
		
		String[] names = new String[10]; //주소값을 names 라는 변수값에 담겠다
		int[] intAry = new int[5]; //크기만 선언
		System.out.println(intAry[0]); 
		double[] heights = new double[3];
		System.out.println(heights[0]);
		
		names[0] = "홍길동"; //변수이름[인덱스값(몇번째위치하는지). 0은 첫번째위치]
		names[1] = "김길동"; //1은 두번째위치
		System.out.println(names[0]);
		System.out.println(names[2]); //null값임(class값)
		
	}
}
