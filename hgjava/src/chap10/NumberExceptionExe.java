package chap10;

import java.util.Scanner;

public class NumberExceptionExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (true) {
			System.out.println("1.추가 2.삭제 3.종료");
			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine()); // "1"->1로 바꿔주는 작업
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
				menu = 1; // 이렇게 넣어줘야함... 적절하게...
			}
			switch (menu) {
			case 1:
				System.out.println("추가합니다");
				break;
			case 2:
				System.out.println("삭제합니다");
				break;
			case 3:
				System.out.println("종료합니다");
				run = false;
			}
			System.out.println("end of prog");
		}
	}

} // end of class
