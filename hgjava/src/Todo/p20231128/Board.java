package Todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date; //ctrl shift o 유틸로.

import lombok.Data;
@Data //따로 메소드 안만들어도 됨 (getter setter)

public class Board {

	// 기능은 여기에 담기 (데이터 담는 용도)
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
	private String wdate; //private는 class안에서만 사용가능. 값 가져오려면 get~ set~ 사용
	
	public Board() { //이렇게 해주면 밑에 this(bnum, title, person, content); 로 한줄로 가능.
		
	}

	public Board(int bnum, String title, String person, String content) {
		Date today = new Date(); // 시스템시간을 기준으로 생성
		
		// Date -> String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		this.bnum = bnum;
		this.title = title;
		this.person = person;
		this.content = content;
		this.wdate = sdf.format(today);
	}

	public Board(int bnum, String title, String person, String content, String wdate) {
		//this();//기본생성자
		
		this(bnum, title, person, content); //매개값을 넣어주면 값을 가져옴. 4줄에서 1줄로 단축가능
		this.wdate = wdate;
	}

	public String showInfo() {
		return bnum + title + person + wdate;

	}

//	public int getBnum() {
//		return bnum;
//	}
//
//	public void setBnum(int bnum) {
//		this.bnum = bnum;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getPerson() {
//		return person;
//	}
//
//	public void setPerson(String person) {
//		this.person = person;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getWdate() {
//		return wdate;
//	}
//
//	public void setWdate(String wdate) {
//		this.wdate = wdate;
//	}

	public String showDetailInfo() {
		String result = "번호: " + bnum + "/ 제목: " + title;
		result += "";
		result += "\n작성자: " + person;
		result += "\n내용: " + content;
		result += "\n일시: " + wdate;
		return result;
	}

}//
