package chap3;

import java.util.*;

public class Exam128 {

	public static void main(String[] args) {
		// 문제4번
		int penNum = 534;
		int stuNum = 30;
		
		int ppsNum = penNum / stuNum;
		int rempNum = penNum % stuNum;
		
		System.out.printf("학생당 연필 수 : %d, 남은 연필 수 : %d\n", ppsNum, rempNum);
		
		// 문제 5번 -> 강제 타입변환
		
		// 문제 6번
		int value = 356;
		System.out.println(value/100*100);
		
		// 문제 7번 -> 부동소수점 표현 방식의 뭄제. 0.1은 0.1보다 큰 값
		//강제 타입 변환 (float)0.1
		
		// 문제 8번
		//사다리꼴의 너비 = (윗변 + 아랫변) * 높이 /2
		int lTop = 5;
		int lBottom = 10;
		int height = 7;
		double area = (((lTop)+(lBottom))*height /2.0);
		System.out.println(area); 
		
		//문제 9번
		Scanner sc = new Scanner(System.in); //sc 는 객체참조변수
		System.out.print("첫번째 수 : ");
		double num1 = sc.nextDouble();
		
		System.out.println("두번째 수 : ");
		double num2 = sc.nextDouble();
		
		if(num2 == 0 ) { //num2 == 0.0 도 가능
			System.out.print("결과:무한대");
		}else {
			System.out.print("결과: " + (num1 / num2));
		}
		
		//문제 10번
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이:" + var4);
		
		//문제 11번 : 기본타입 데이터 비교 (==), 참조타입 비교(equals()
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아이디:");
		String name = scanner.nextLine();
		
		System.out.print("패스워드:");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패:아이디 존재하지 않음");
		}
		
		//문제 13번
			
		
	}//end main

}//end class
