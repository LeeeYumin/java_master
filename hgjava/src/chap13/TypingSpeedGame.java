package chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//1.목록출력 Scanner 사용해서 입력값 저장 2. list 컬렉션 사용.
//사용자가 입력한 값을 컬렉션의 값과 비교해서 같은 단어가 있으면 삭제 remove.
//시작시점 ~ 종료시점 걸린시간을 초단위로 계산.
//완료하는데 35초가 걸렸습니다 출력하고 종료.

public class TypingSpeedGame {
	public static void main(String[] args) {
		
		
		String word = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();
		
		Scanner scn = new Scanner(System.in);
		
		for(String str : words) {
			list.add(str);
		}
		boolean run = true;
		
		while (run) {
		//목록을 출력한다
			for(int i = 0; i < list.size(); i++) {
				 if(list == word.split(words)) {
					 exists = true;
					 
		//입력값과 목록값과 비교해서 있으면 제거.			
		list.remove(0);
		list.remove(0);
		list.remove(0);
		
		System.out.println(list.size());
		}
		
//		for(String str : list) {
//			System.out.println(str);
//		}
		
				
		System.out.println("완료하는데 " + " 초가 걸렸습니다");
		
			
			}
	}//end of main
// end of class
