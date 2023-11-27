package chap5;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null; //배열 선언
		String[] names = null;
		
		//1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5. 종료
		boolean run = true;
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5. 종료");
			int menu = scn.nextInt(); //사용자가 입력한 걸 처리하기 위한 Enter..
			scn.nextLine();
			
			switch(menu) { //조건문
			case 1 : 
				System.out.println("학생수입력>>");
				studentNum = scn.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
			case 2 : 
				System.out.println("점수입력>>"); //배열에 있는 값 만큼만 받을 수 있음
				//for 반복문
				for (int i=0; i < scores.length; i++) {
					System.out.println("names[" + i + "]>> ");
					names[i] = scn.nextLine();
					System.out.println("scores[" + i + "]>> ");
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3 : 
				System.out.println("목록출력>>");
				//for 반복문
				for (int i=0; i < scores.length; i++) {
					System.out.println("이름은 " + names[i] + ", 점수는 " + scores[i] + "\n");
				}
				break;
			case 4 : 
				System.out.println("분석>>");
				//최고점수 출력. 구현
				int maxScore = 0;
				String maxName = "";
				double avg = 0;
				int sum = 0;
				
				//for (int num : scores) {
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i]; //sum = sum + num; 도 가능
					if (maxScore < scores[i]) {
						maxScore = scores[i];
						maxName = names[i];
					}
				}
				avg = sum * 1.0 / scores.length;
				System.out.println(maxName + "의 " + ", 점수 " + maxScore + ", 평균 : " + avg);
				break;
			case 5 : 
				System.out.println("종료>>");
				run = false;
				break;
			} //end of switch.
		} //end of while.
		System.out.println("end of prog.");

	} //
 
} //
