package com.yedam;

//실행(구현)

import java.util.*;

public class CafeApp {
	public static void main(String[] args) {
		CafeDAO dao = new CafeDAO();
		boolean logon = true;
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		int cuser = 0;
		while (logon) {
			System.out.println("안녕하세요! 로그인 후 주문이 가능합니다.");
			System.out.println("===============================");
			System.out.println("회원번호 4자리를 입력해주세요.");
			cuser = Integer.parseInt(scn.nextLine());
			System.out.println("이름을 입력해주세요.");
			String cname = scn.nextLine();

			if (dao.login(cuser, cname)) {
				logon = false;
				System.out.println("확인되었습니다.");
			} else {
				System.out.println("다시 확인해주세요.");
			}
		} // log on

		while (run) {
			System.out.println("1.주문하기 2.주문내역 3.주문취소 4.주문수정 5.종료");
			System.out.println("=========================================");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1: // 1.주문하기(등록)
				for (Product p : dao.orderview()) {
					System.out.println(p.toString());
				}
				System.out.println("음료 번호를 선택해주세요(필수)>>");
				int pnumber = Integer.parseInt(scn.nextLine());
				for (Dessert d : dao.orderview2()) {
					System.out.println(d.toString());
				}
				System.out.println("디저트 번호를 선택해주세요(선택)>>");
				int dnumber = Integer.parseInt(scn.nextLine());
				System.out.println("포장유무를 선택해주세요(필수. 매장취식은 1입니다.)>>");
				String take = scn.nextLine();
				// Product prod = new Product(pnumber, dnumber, take);
				if (dao.order(pnumber, dnumber, cuser, take)) {
					System.out.println("주문이 완료되었습니다.");
				} else {
					System.out.println("저장 중 오류 발생..");
				}
				break;

			case 2: // 2.주문내역
				System.out.println("회원번호를 입력해주세요.");
				cuser = Integer.parseInt(scn.nextLine());
				ArrayList<Receipt> receipts = dao.receipt(cuser);
				if (receipts.size() != 0) {
					for (Receipt receipt : receipts)
						System.out.println(receipt.showInfo());
				} else {
					System.out.println("주문 내역이 없습니다.");
				}
				break;

			case 3: // 3.주문취소 (동일회원 일괄삭제)
				System.out.println("회원번호를 입력해주세요.");
				cuser = Integer.parseInt(scn.nextLine());
				System.out.println("주문을 취소하시겠습니까? 1:주문유지 2:삭제");
				int choice = Integer.parseInt(scn.nextLine());
				if (choice == 1) {
					System.out.println("주문이 유지됩니다.");
				} else {
					if (dao.removeOrder(cuser)) {
						System.out.println("삭제되었습니다.");
					} else {
						System.out.println("주문번호가 없습니다.");
					}
				}
				break;

			case 4: // 4.주문수정
				System.out.println("회원번호를 입력해주세요.");
				cuser = Integer.parseInt(scn.nextLine());
				System.out.println("주문한 메뉴를 수정하시겠습니까? 1:수정 2:수정취소");
				int modi = Integer.parseInt(scn.nextLine());
				if (modi == 1) {
					for (Product p : dao.orderview()) {
						System.out.println(p.toString());
					}
					System.out.println("수정할 메뉴를 입력해주세요.");
					System.out.println("음료 번호 입력>>");
					String pname = scn.nextLine();
					for (Dessert d : dao.orderview2()) {
						System.out.println(d.toString());
					}
					System.out.println("디저트 번호 입력>>");
					String dname = scn.nextLine();
					System.out.println("포장유무 ( 매장취식 : 1 )>>");
					take = scn.nextLine();
					if (dao.modifyOrder(pname, dname, take, cuser)) {
						System.out.println("수정이 완료되었습니다.");
					} else {
						System.out.println("존재하는 회원번호가 아니거나 주문 이력이 없습니다.");
					}
				} else if (modi == 2) {
					System.out.println("수정이 취소되었습니다.");

				} else {
					System.out.println("수정 값이 올바르지 않습니다..");
				}
				break;

			case 5: // 5.종료
				System.out.println("주문을 종료합니다.");
				run = false;

			} // switch

		} // end of while
		System.out.println("~키오스크 종료~");

	}// end of main

} // end of class
