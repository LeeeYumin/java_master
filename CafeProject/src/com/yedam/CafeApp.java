package com.yedam;
//실행

import java.util.*;

public class CafeApp {
	public static void main(String[] args) {
		CafeDAO dao = new CafeDAO();
		boolean logon = true;
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (logon) {
			System.out.println("로그인 후 주문이 가능합니다");
			System.out.println("=====================");
			System.out.println("회원번호를 입력해주세요");
			int cuser = Integer.parseInt(scn.nextLine());
			System.out.println("이름을 입력해주세요");
			String cname = scn.nextLine();
			
			if (dao.login(cuser, cname)) {
				logon = false;
				System.out.println("확인되었습니다");
			}					
			else {
				System.out.println("다시 확인해주세요");
			}
		}
		//logon

		
		while (run) {
			System.out.println("1.주문하기 2.주문내역 3.주문취소 4.주문수정 5.종료");
			System.out.println("=========================================");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1: // 1.주문하기(등록)
				System.out.println("음료 번호를 선택해주세요(필수)>>");
				
				int pnumber = Integer.parseInt(scn.nextLine());
				System.out.println("디저트 번호를 선택해주세요(선택)>>");
				int dnumber = Integer.parseInt(scn.nextLine());
				System.out.println("포장유무를 선택해주세요(필수)>>");
				String take = scn.nextLine();

				Product prod = new Product(pnumber, dnumber, take);
				if (dao.order(pnumber, dnumber, take)) {
					System.out.println("주문이 완료되었습니다");
				} else {
					System.out.println("저장 중 오류 발생");
				}
				break;

			case 2: // 2.주문내역
				Member[] memAry = dao.getMemberList();
				for (Member mlist : memAry) {
					if (mlist != null) {
						mlist.showInfo();
					}
				}
				break;

			case 3: // 3.주문취소
				System.out.println("회원번호를 입력해주세요");
				int cuser = scn.nextInt();
				System.out.println("주문을 취소하시겠습니까? 1:취소 2:주문유지");
				if (dao.removeOrder(cuser)) {
					
					System.out.println("삭제되었습니다");
				} else {
					System.out.println("주문사항이 유지됩니다");
				}
				break;

			case 4: // 4.주문수정
				System.out.println("회원번호를 입력해주세요");
				cuser = scn.nextInt();
				System.out.println("주문한 메뉴를 수정하시겠습니까? 1:수정 2:수정취소");
				int modi = Integer.parseInt(scn.nextLine());
				// 1,2,3 중에서 하나 누르면 "변경할 메뉴를 입력해주세요" 뜨게
				if (modi == 1) {
					System.out.println("수정할 메뉴 번호를 입력해주세요");
				}
				System.out.println("수정이 취소되었습니다");
				break;

			case 5: // 5.종료
				System.out.println("주문을 종료합니다");
				run = false;

			} // switch

		} // end of while
		System.out.println("키오스크 종료");

	}// end of main

} // end of class
