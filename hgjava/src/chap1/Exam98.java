package chap1;

import java.util.Scanner;

public class Exam98 {

	public static void main(String[] args) {
		//1번
		String name = "감자바";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		System.out.println("이름: " + (name));
		System.out.print("나이: " + (age)+"\n");
		System.out.printf("전화: %s - %s - %s\n", tel1,tel2,tel3);
		
		//2번
		Scanner scanner= new Scanner(System.in);
		
		System.out.print("첫번째 수:");
		String strNum1 = scanner.nextLine();
		
		System.out.print("두번째 수:");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과:" + result);
		
		//3번
		System.out.println("[필수 정보 입력]");
		System.out.print("1. 이름:");
		String name1 = scanner.nextLine();
		System.out.print("2. 주민번호 앞 6자리:");
		String number = scanner.nextLine();
		System.out.print("3. 전화번호:");
		String tell = scanner.nextLine();
		
		System.out.println(name1);
		System.out.println(number);
		System.out.println(tell);
		
		

	}//end main

}//end class
