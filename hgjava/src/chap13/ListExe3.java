package chap13;

import java.util.Scanner;

import chap7.Friend;

public class ListExe3 {
	public static void main(String[] args) {

	static Scanner scn = new Scanner(System.in);
	// 회원등록(회원번호, 이름, 포인트)
	// 1. 등록 2.이름조회(여러개 조회 가능) 3. 포인트변경 4.삭제(회원번호 1건으로 지움) 5. 종료
	system.out.println("회원번호, 이름, 포인트");

	String input = scn.nextLine();
			String[] inAry = input.split(" ");
			System.out.println(inAry[0]);
			System.out.println(inAry[1]);
			System.out.println(inAry[2]);
			System.out.println("종료");
			List <Member> members = new ArrayList<>;
		
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu){
				case 1: 
					addMember();
					break;
				case 2: 
					searchMem();
					break;
				case 3: 
					pointChange();
					break;
				case 4: 
					delMember();
					break;
				default:
					System.out.println("종료");
					run = false;
				}

	list<String>members = addMember() {
					System.out.println("1.번호 2.이름 3.포인트");
					int subMenu = Integer.parseInt(scn.nextLine());
				
	}
	
	list<String>members = searchMem() { 
		for(int i = 0; i < getMemberName; i++) {
			if(member<> != null) {
				System.out.println(member<>.showInfo());
			}
		}
		return members;
	}
	}
				
	} // end of main
} // end of class
