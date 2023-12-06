package chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//1.목록출력 Scanner 사용해서 입력값 저장 2. list 컬렉션 사용.
//사용자가 입력한 값을 컬렉션의 값과 비교해서 같은 단어가 있으면 삭제 remove.
//시작시점 ~ 종료시점 걸린시간을 초단위로 계산.
//완료하는데 35초가 걸렸습니다 출력하고 종료.
//도움요청해서 해결함ㅠ 복잡하군

public class TypingSpeedGame {
	public static void main(String[] args) {

		String word = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();

		Scanner scn = new Scanner(System.in);

		for (String str : words) {
			list.add(str);
		}
		boolean run = true;
		long start = System.currentTimeMillis(); //while 문 시작하기 전에 시작시간
		while (run) {
			for (String str : list) {
				System.out.println(str);
			}
			// 목록을 출력한다
			String a = scn.nextLine();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(a)) {
					list.remove(i); // 같은 단어가 입력되면 지워주는 for 문 (입력값과 목록값과 비교해서 있으면 제거)
				}
				if (list.size() == 0) {
					run = false; 
				}
				System.out.println(list.size());
			}
			long end = System.currentTimeMillis(); //while 문 끝나고 끝나는 시간
			System.out.println("완료하는데 " + (end - start) + " 초가 걸렸습니다");

		}
	}// end of main
}// end of class
