package Todo.p20231128;

//메인메소드 담는곳. 배열만 선언
import java.util.Scanner;

import chap6.User;
import chap6.UserExe; //패키지 다르면 import해주기

public class BoardApp {
	static BoardExe exe = new BoardExe();

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		String id = null; // while문 밖으로 뺌.

		UserExe uexe = new UserExe();

		while (true) {
			System.out.println("id를 입력>>> ");
			id = scn.nextLine(); // while문 밖으로 빼서 앞에 String 삭제
			System.out.println("pw를 입력>>> ");
			String pw = scn.nextLine();
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "님 환영합니다");
				break;
			} else {
				System.out.println("id, pw 확인하세요");
			}
		} // 로그인처리

		// 초기값 생성
		exe.initData();

		while (run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("제목 입력>>");
				String title = scn.nextLine();
				System.out.println("내용 입력>>");
				String content = scn.nextLine();
				System.out.println("번호 입력>>");
				String wdate = scn.nextLine();

				Board board = new Board(exe.getSequence(), title, content, wdate);

				if (exe.addBoard(board)) {
					System.out.println("입력 성공");
				} else {
					System.out.println("처리 실패");
				}
				break;

			case 2: // 목록보여줌 -> 페이지보기
				Board[] boardAry = exe.boardList(); //전체목록가지고오기
				showList(boardAry, 1); //전체 중 1페이지만보겠다
				while (true) {
					int page = Integer.parseInt(scn.nextLine());
					if (page == 0) {
						break;
					}
					showList(boardAry, page);
				}
				break;

			case 3:
				System.out.println("글번호 입력>> ");
				int bnum = Integer.parseInt(scn.nextLine());
				Board result = exe.getBoard(bnum);
				if (result != null) {
					System.out.println(result.showDetailInfo());
				} else {
					System.out.println("조회 내용 없음");
				}
				break;

			case 4: // 수정
				System.out.println("수정한 글번호>>> ");
				bnum = Integer.parseInt(scn.nextLine());
				System.out.println("수정한 글내용>>> ");
				content = scn.nextLine();
				// 권한 체크
				if (!exe.checkResponsibility(id, bnum)) {
					System.out.println("수정 권한없습니다..");
					continue;
				}

				if (exe.modBoard(bnum, content)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("처리 실패");
				}
				break;

			case 5: // 삭제
				System.out.println("삭제할 글 번호>>>");
				bnum = Integer.parseInt(scn.nextLine());
				// 권한 체크
				if (!exe.checkResponsibility(id, bnum)) {
					System.out.println("삭제 권한없습니다..");
					continue;
				}

				if (exe.remBoard(bnum)) {
					System.out.println("삭제 성공");
				} else {
					System.out.println("삭제 실패");
				}
				break;

			case 6:
				System.out.println("프로그램 종료합니다");
				run = false;

			}

		}
		System.out.println("end of prog");
	} // end of main

	public static void showList(Board[] boardAry, int page) {
		// 페이징처리
		Board[] pageAry = exe.pageList(boardAry, page); //boardAry:전체배열 의미
		System.out.println("글번호 제목    작성자 작성일시");
		System.out.println("========================");
		for (Board brd : pageAry) {
			if (brd != null)
				System.out.println(brd.showInfo());
		}
		// 전체페이지 계산하고 출력
		int cnt = exe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0);

		for (int i = 1; i <= totalPage; i++) {
			System.out.println(i + " ");
		}
		System.out.println("\n페이지를 선택하세요>> 종료:0 입력.");
	}

} // end of class