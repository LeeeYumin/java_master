package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 1 ~ 50 : 369게임
		
		int count = 0; // 3, 6, 9 숫자의 갯수 체크 변수
		// 숫자는 1~50 (반복문)
		for(int i=1; i <= 50; i++){ 
			count = 0;
			if(i%10 == 3 || i%10 == 6 || i%10 ==9) {  // 일의 자리에 3,6,9 있는지 갯수 체크. ||는 OR 의미
			count ++;
			}
			int ten = (int)(i/10);  // 십의 자리에 3,6,9 갯수 체크
			if(ten%10 == 3 || ten%10 == 6 || ten%10 == 9) {
				count ++;
			}
			switch(count) {		
			case 0 : System.out.print(i+"\t"); break; // 갯수가 0 -> 숫자 출력
			case 1 : System.out.print("♥\t"); break; // 갯수가 1 -> ♥
			case 2 : System.out.print("♥♥\t"); // 갯수가 2 -> ♥♥
			}
			if(i % 10 ==0) { // 한 줄에 10개씩 출력
				System.out.println();
			}
		}
		// if(i%10 == 3 || i%10 == 6 || 1%10 == 9) count++;
		// if(i/10 == 3 || i/10 == 6 || 1/10 == 9) count++; 이렇게도 가능.
			
		
		//동전 교환
		Scanner scr = new Scanner(System.in);
		System.out.println("##교환할 금액 : ");
		int money = scr.nextInt();
		int remoney = 0;
		
		System.out.println("500원 짜리 : " + money/500 + "개");
		remoney = money%500;
		System.out.println("100원 짜리 : " + remoney/100 + "개");
		remoney %= 100; 
		System.out.println("50원 짜리 : " + remoney/50 + "개");
		remoney %= 50;
		System.out.println("10원 짜리 : " + remoney/10 + "개");
		remoney %= 10;
		System.out.println("교환 금액 : " +(money-remoney) + "원");
		System.out.println("남은 금액 : " + remoney + "원");
		
		
		//숫자추측게임 : 1에서 100 사이 수 발생
		//int com 숫자발생 = (int)(Math.random()*100)+1; 하고 while(true) { }
		//반복문 실행하면 숫자 입력 받음
			//if(my number == com) {축하합니다 break;} 같은 경우 먼저 넣어주고 반복문 탈출.
			//밑에 입력 숫자 > com -> down 하세요 알림
			//입력 숫자 < com -> up 하세요 알림	
		Scanner myNum = new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		int com = (int)(Math.random()*100)+1;
		
		//11.27깃허브 하고 아무거나 써봄!!
		
 
	} // end main

} // end class
