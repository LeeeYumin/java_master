package Todo.p20231205;

import java.util.ArrayList;
import java.util.Scanner;

//도서앱. 1.등록 2.목록 3.수정 4.삭제 5.종료 + 컬렉션 적용
//1 선택하면 도서코드입력>> 도서명입력>> 저자입력>> 출판사입력>> 가격입력>>
//마지막"저장되었습니다"
//2 선택하면 도서코드 도서명 저자 가격 뜨게
//3 선택하면 도서코드입력>> 가격입력>> "수정되었습니다"
//4 선택하면 도서코드입력>> "삭제되었습니다"
public class BookApp {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		BookExe exe = new BookExe();
		boolean run = true;

		while (run) {

			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("도서코드 입력>>");
				String bCode = scn.nextLine();
				System.out.println("도서명 입력>>");
				String bName = scn.nextLine();
				System.out.println("저자 입력>>");
				String writer = scn.nextLine();
				System.out.println("출판사 입력>>");
				String bCom = scn.nextLine();
				System.out.println("가격 입력>>");
				int price = Integer.parseInt(scn.nextLine());

				Book std = new Book(bCode, bName, writer, bCom, price);
				if (exe.addBook(std)) {
					System.out.println("저장 되었습니다.");
				} else {
					System.out.println("저장 중 오류 발생");
				}
				break;
			case 2: // 목록보기
				ArrayList<Book> stdAry = exe.getBookList();
				for (Book stdnt : stdAry) {
					if (stdnt != null) {
						stdnt.showInfo();
					}
				
				}
				break;
			case 3: // 수정
				System.out.println("조회할 도서코드 입력>>");
				bCode = scn.nextLine();
				System.out.println("가격 입력>>");
				price = Integer.parseInt(scn.nextLine());
				if (exe.modifyBook(bCode, price)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				break;
			case 4:// 삭제
				System.out.println("삭제할 도서코드 입력>>");
				bCode = scn.nextLine();
				if (exe.removeBook(bCode)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다");
				run = false;
			}// end of switch
			
		} // end of while
		
		System.out.println("end of prog");
	}

} // end of main