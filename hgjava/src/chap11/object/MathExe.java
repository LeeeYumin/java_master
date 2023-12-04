package chap11.object;

public class MathExe {
	public static void main(String[] args) {
		long result = Math.round(-1.2);
		System.out.println("round : " + result);

		long result2 = (long) Math.rint(-1.7);
		System.out.println("rint : " + result2);

		// 61점~100점 범위의 수를 나오게 하기
		// Math.random() 0 <= x < 1
		for (int i = 1; i <= 10; i++) {
			int r = 61 + (int) (Math.random() * 40); // 40을 곱하면 0<=x<40. 여기서 61을 더하면 61<=x<101
			System.out.println(r);
		}

		// 문제 : 1부터 6까지 수 (주사위) 를 나오게 만들기
		int num = (int) (Math.random() * 6) + 1;
		// 생성된 값이 배열에 있는지 체크하고
		int[] numbers = new int[5];
		// 중복되지 않는 값을 배열에 추가. 배열에 값이 다 저장되면 종료
//		for(int j = 0; j < numbers.length; j++) {
//			if(numbers[] == num)
//				return true;
//				}
//				return false;
//				
//			System.out.println(numbers);
//		}// end of main

		// 교수님 풀이 1부터 6까지 수 (주사위) 를 나오게 만들기
		for (int i = 0; i < numbers.length; i++) {
			boolean exist = false;
			int no = 1 + (int) (Math.random() * 6);
			// 체크
			for (int j = 0; j < 1; j++) {
				if (numbers[j] == no)
					exist = true;
			}
			// 있으면 저장 안하고..
			if (exist) {
				i--;
				continue;
			}
			// 없으면 저장하고..
			numbers[i] = no;
		}

	} // end of main
}// end of class