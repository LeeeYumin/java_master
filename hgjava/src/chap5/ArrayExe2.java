package chap5;

public class ArrayExe2 {

	public static void main(String[] args) {
		// 정수를 담을 수 있는 배열을 생성(크기는 10개의 정수를 저장).
		// 변수 이름은 intAry 10, 20, ... ,100 저장.
		// 출력
		int[] intAry = new int[10]; //{10, 20 ,30, 40, 50, 60, 70, 80, 90, 100} 라고 씀... 이것도 되긴 함.
		for(int i=0; i<intAry.length; i++) {
			intAry[i] = (i + 1) * 10; //i*10+10
		}
		//출력. 확장for구문. 배열의 크기 만큼만 반환하겠다? 
		int sum = 0; // 50보다 큰 수를 저장
		double avg = 0;
		int count = 0;
		for (int num : intAry) {
			System.out.println(num);
			if(num > 50) { //50보다 큰 수를 누적합. sum은 60부터 시작해서 70 더하면 130. 130에서 80더하면 210... 이렇게.
				sum = sum + num;
				count++;
			}
		}
//		for (int num : intAry) {
//			System.out.println(avg);
//			if(avg = intAry.length) {
//				count = intAry.length;
//			}
//		} 내가 접근한거 완전 잘못함...
		avg = sum / count;
		System.out.println("50보다 큰 수의 합계: " + sum);
		System.out.println("50보다 큰 수의 평균: " + (sum/count));
	} //

} //
