package Todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date; //ctrl shift o 유틸로.

public class Board {

	// 기능은 여기에 담기
	// 게시판 (게시글번호/제목/작성자/내용/작성일시)-private로 선언하기
	// ------------------------------------
	// 1. 자바게시판입니다 user01
	// 2. 공부합시다 user02
	// 3. SQL이 기대됩니다 user03
	// ------------------------------------이 밑은 상세보기기능
	// 번호 : 1/ 제목 : 자바게시판입니다
	// 작성자 : user01
	// 내용 : 오늘은 숙제로 자바게시판을 만들어봅시다
	// 일시 : 2023-11-28
	// -------------------------------------
	// 1.등록 2.목록 3.상세조회 4.종료 까지만 (기능만 비슷하게 만들어보기.)

	private int bnum;
	private String title;
	private String person;
	private String content;
	private String wdate;

	public Board(int bnum, String title, String person, String content) {
		Date today = new Date(); // 시스템시간을 기준으로 생성

		// Date -> String ->Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		this.bnum = bnum;
		this.title = title;
		this.person = person;
		this.content = content;
		this.wdate = sdf.format(today);
	}

	public Board(int bnum, String title, String person, String content, String wdate) {
		this.bnum = bnum;
		this.title = title;
		this.person = person;
		this.content = content;
		this.wdate = wdate;
	}

	String showInfo() {
		return bnum + title + person + wdate;

	}

	int getBnum() {
		return bnum;
	}

	void setBnum(int bnum) {
		this.bnum = bnum;
	}

	String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	String getPerson() {
		return person;
	}

	void setPerson(String person) {
		this.person = person;
	}

	String getContent() {
		return content;
	}

	void setContent(String content) {
		this.content = content;
	}

	String getWdate() {
		return wdate;
	}

	void setWdate(String wdate) {
		this.wdate = wdate;
	}

	String showDetailInfo() {
		String result = "번호: " + bnum + "/ 제목: " + title;
		result += "";
		result += "\n작성자: " + person;
		result += "\n내용: " + content;
		result += "\n일시: " + wdate;
		return result;
	}

}//
