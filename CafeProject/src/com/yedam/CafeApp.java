package com.yedam;
//실행

import java.util.*;

public class CafeApp {

	public static void main(String[] args) {
		CafeDAO dao = new CafeDAO();
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		
		
		while (run) {
			System.out.println("1.주문하기 2.주문내역 3.주문취소 4.주문수정 5.종료");
			System.out.println("회원번호를 입력해주세요");
			int user = Integer.parseInt(scn.nextLine());
			System.out.println("이름을 입력해주세요");
			String name = scn.nextLine();
			
			if(dao.step1(user, name)) {
				System.out.println("확인되었습니다");
			}else {
				System.out.println("다시 확인해주세요");
			}
			continue;
			
			
			switch(==1) {
			case 1 : //주문하기(등록)
				System.out.println("음료 번호를 선택해주세요(필수)>>");
				int pnumber = Integer.parseInt(scn.nextLine());
				System.out.println("음료 번호를 선택해주세요(선택)>>");
				int dnumber = Integer.parseInt(scn.nextLine());
				System.out.println("포장유무를 선태갷주세요(필수)>>");
				int take = Integer.parseInt(scn.nextLine());
				
				
				
			case 2 : //주문내역
				Member[] memAry = dao.getMemberList();
				for (Member mlist : memAry) {
					if(mlist !=null) {
						mlist.showInfo();
					}
				}
				break;
				
			case 3 : //주문취소
				
				
			case 4 : //주문수정
				System.out.println("회원번호를 입력해주세요");
				user = scn.nextInt();
				System.out.println("변경할 항목을 입력해주세요. 1:음료 2:디저트 3:포장유무");
				
			
			case 5 : //종료
				System.out.println("주문을 종료합니다");
				run = false;
			
			}
			
			
		}//end of while
		System.out.println("키오스크 종료");
		
	}//end of main
	
	
} //end of class
