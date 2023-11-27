package chap5;

public class ArrayExe3 {

	public static void main(String[] args) {
		String[] nameAry = {"홍길동", "김길동", "홍길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		int count = 0;
		//for반복문 활용
		for (String name : nameAry) {
			if (name.equals(search)) {
			count++;
			}
		}
		
		System.out.println(search+"은 총 " + count + "명 입니다.");
		
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		for (int num : scores) { //scores 반복문. num에 88, 68 순으로 받겠다는 의미
			if (maxScore < num) { //num에 처음에 88을 받고 그 다음에 scores에 68, num에 있는(있던?) 88을 받아서 비교.
				maxScore = num;
			}
		}
		System.out.println("max값: " + maxScore);

	} //

} //
