package Todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

//저장소 : boards
public class BoardExe {
	Board[] boards;

	BoardExe() {
		boards = new Board[100];
	}

	// 초기값 생성
	void initData() {
		boards[0] = new Board(1, "첫번째글", "user01", "첫번째 글 입력중입니다", "23-11-12");
		boards[1] = new Board(2, "두번째글", "user02", "두번째 글 입력중입니다", "23-11-15");
		// boards[2] <--- 5번글 들어갈 위치
		boards[3] = new Board(4, "네번째글", "user03", "네번째 글 입력중입니다", "23-11-17");
		boards[2] = new Board(3, "세번째글", "user03", "세번째 글 입력중입니다", "23-11-17");

		boards[4] = new Board(5, "다섯번째글", "user03", "세번째 글 입력중입니다", "23-11-17");
		boards[5] = new Board(6, "여섯번째글", "user03", "세번째 글 입력중입니다", "23-11-18");
		boards[6] = new Board(7, "일곱번째글", "user03", "세번째 글 입력중입니다", "23-11-19");
		boards[7] = new Board(8, "여덟번째글", "user03", "세번째 글 입력중입니다", "23-11-19");
	}

	// 등록. 글번호/제목/작성자/내용/작성일자. => 반환값 boolean.
	boolean addBoard(Board board) { // Board board로 매개변수지정
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) { // 빈칸이 아니라면 채워넣음
				boards[i] = board;
				return true; // break; //반복문 종료 .boolean 이니까 t/f로.
			}
		}
		return false;
	}

	// 목록. 반환값은 배열. 5줄의 Board[] boards; 이거 말함
	Board[] boardList() {
		// boards => 새로운 배열에 정렬된 값으로 반환.
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			// 위치변경작업
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i] != null && boards[i + 1] != null) {
					if (boards[i].getBnum() > boards[i + 1].getBnum())
						;
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
		return boards;
	} // end of boardList().

	// 배열, 해당되는 페이지 => 페이지의 5건 반환
	Board[] pageList(Board[] ary, int page) {
		Board[] resultAry = new Board[5];

		int start = (page - 1) * 5;
		int end = page * 5;
		int j = 0; // 0부터 시작하는 새로운 배열 01234
		for (int i = 0; i < ary.length; i++) { // 5개씩. 0부터 5까지
			if (i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;

	}

	// 단건조회. 매개변수는 글번호. 반환값은 Board타입.
	Board getBoard(int boardNo) { // Board.java에서 만들어준 변수이름이랑 상관없음
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBnum() == boardNo) {
				return boards[i];
			}
		}
		return null;
	}

	// 신규번호 : 현재글번호max + 1
	int getSequence() {
		int seqNo = 1;
		// 배열에서 글번호의 max가져오기
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBnum() > max) {
				max = boards[i].getBnum();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}

	// 수정. 매개값(글번호, 글내용) => boolean.
	boolean modBoard(int no, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBnum() == no) {
				boards[i].setContent(content);
				boards[i].setWdate(sdf.format(today));
				return true;
			}
		}
		return false;
	}

	// 삭제 . 매개값(글번호) => boolean
	boolean remBoard(int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBnum() == no) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}

	// 사용자가 해당글번호의 수정, 삭제 권한 있는지 체크
	// 권한이 있으면 t 없으면 f. boolean 타입 사용
	boolean checkResponsibility(String id, int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBnum() == no && boards[i].getPerson().equals(id)) {
				return true;
			}
		}
		return false;
	}// end of checkResponsibility

	// 게시글을 담고 있는 배열에서 값이 있는 건수를 반환
	int getBoardCount() {
		int realCnt = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}

}