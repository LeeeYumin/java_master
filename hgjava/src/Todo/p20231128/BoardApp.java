package Todo.p20231128;

//메인메소드 담는곳. 배열만 선언
import java.util.Scanner;
import chap6.User;
import chap6.UserExe; //패키지 다르면 import해주기

// M(odel) V(iew) C(ontrol) MVC view역할은 html. M,C는 java.

public class BoardApp { // public은 패키지가 달라도 다 접근가능
	// static BoardExe exe = new BoardExe(); //이건 한번 만들어놓고 계속 씀
	// 데이터마다 다른 정보를 담을 필요가 없는 클래스는 static 멤버로 선언..

	private Scanner scn = new Scanner(System.in); //필드임
	private String id = null; // while문 밖으로 뺌->더 위로 올림. 이것도 필드
	
	//싱글톤 방식의 인스턴스 생성방식
	private static BoardApp instance = new BoardApp();
	
	//생성자
	private BoardApp() {
		
	}
	
	public static BoardApp getInstance() { //static : 다른 클래스에서 사용할수있게
		return instance;
	}
	
	private void boardAdd(){
		System.out.println("제목 입력>>");
		String title = scn.nextLine();
		System.out.println("내용 입력>>");
		String content = scn.nextLine();
		System.out.println("번호 입력>>");
		String wdate = scn.nextLine();

		Board board = new Board(BoardExe.getSequence(), title, content, wdate);

		if (BoardExe.addBoard(board)) {
			System.out.println("입력 성공");
		} else {
			System.out.println("처리 실패");
		}
	} //end of boardAdd.
	
	private void boardList() {
		Board[] boardAry = BoardExe.boardList(); // 전체목록가지고오기
		showList(boardAry, 1); // 전체 중 1페이지만보겠다
		while (true) {
			int page = Integer.parseInt(scn.nextLine());
			if (page == 0) {
				break;
			}
			showList(boardAry, page);
		}
	} //end of boardList.
	
	private void getBoard() {
		System.out.println("글번호 입력>> ");
		int bnum = Integer.parseInt(scn.nextLine());
		Board result = BoardExe.getBoard(bnum);
		if (result != null) {
			System.out.println(result.showDetailInfo());
		} else {
			System.out.println("조회 내용 없음");
		}
	} //end of getBoard.
	
	private void boardEdit() {
		System.out.println("수정한 글번호>>> ");
		int bnum = Integer.parseInt(scn.nextLine());
		System.out.println("수정한 글내용>>> ");
		String content = scn.nextLine();
		// 권한 체크
		if (!BoardExe.checkResponsibility(id, bnum)) {
			System.out.println("수정 권한없습니다..");
			//continue;
			return;
		}

		if (BoardExe.modBoard(bnum, content)) {
			System.out.println("변경 성공");
		} else {
			System.out.println("처리 실패");
		}
	} //end of boardEdit.
	
	private void boardDel() {
		System.out.println("삭제할 글 번호>>>");
		int bnum = Integer.parseInt(scn.nextLine());
		// 권한 체크
		if (!BoardExe.checkResponsibility(id, bnum)) {
			System.out.println("삭제 권한없습니다..");
			//continue;
			return;
		}

		if (BoardExe.remBoard(bnum)) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	} //end of boardDel.
	
	public void start() { // void는 리턴X.반환값유무.. ()안은 매개값
		boolean run = true;

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
		BoardExe.initData();

		while (run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: //글등록
				boardAdd();
				
				break;

			case 2: // 목록보여줌 -> 페이지보기
				boardList();
				break;

			case 3: //조회
				getBoard();
				break;

			case 4: // 수정
				boardEdit();
				break;

			case 5: // 삭제
				boardDel();
				break;

			case 6:
				System.out.println("프로그램 종료합니다");
				run = false;

			}

		}
		System.out.println("end of prog");
	} // end of main

	private void showList(Board[] boardAry, int page) { //안에서만 쓸거라서 public -> private (클래스 안에서 접근허용)
		// 페이징처리
		Board[] pageAry = BoardExe.pageList(boardAry, page); // boardAry:전체배열 의미
		System.out.println("글번호 제목    작성자 작성일시");
		System.out.println("========================");
		for (Board brd : pageAry) {
			if (brd != null)
				System.out.println(brd.showInfo());
		}
		// 전체페이지 계산하고 출력
		int cnt = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0);

		for (int i = 1; i <= totalPage; i++) {
			System.out.println(i + " ");
		}
		System.out.println("\n페이지를 선택하세요>> 종료:0 입력.");
	}

} // end of class