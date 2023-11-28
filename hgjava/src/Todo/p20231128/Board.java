package Todo.p20231128;

import java.util.Scanner;

public class Board {
	public static void main(String[] args) {
	//기능은 여기에 담기
	//게시판 (게시글번호/제목/작성자/내용/작성일시)-private로 선언하기
	//------------------------------------
	//1. 자바게시판입니다   user01
	//2. 공부합시다       user02
	//3. SQL이 기대됩니다  user03
	//------------------------------------이 밑은 상세보기기능
	//번호 : 1/ 제목 : 자바게시판입니다
	//작성자 : user01
	//내용 : 오늘은 숙제로 자바게시판을 만들어봅시다
	//일시 : 2023-11-28
	//-------------------------------------
	//1.등록 2.목록 3.상세조회 4.종료 까지만 (기능만 비슷하게 만들어보기.)
	
	Scanner scn = new Scanner(System.in);
	
	private int bnum;
	private String title;
	private String person;
	private String content;
	private String date;
	
	while (run) {
		System.out.println("1.등록 2.목록 3.상세조회 4.종료");
		int bnum = Integer.parseInt(scn.nextLine());
		
	
	
		
		
	}
		
		
	void showAllInfo() { 
		System.out.println("번호 : " + bnum + "/ 제목 : " + title + "\t"
							+ "작성자 : " + person + "\t"
							+ "내용 : " + content + "\t"
							+ "일시 : " + date);
		System.out.print("--------------------------------------------");
		System.out.println("1.등록 2.목록 3.상세조회 4.종료");
	}
	
	
}//
