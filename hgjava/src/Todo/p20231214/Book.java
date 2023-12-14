package Todo.p20231214;

import lombok.Data;

//줄 간격 수정하고 메소드정의 void showInfo 빼고 지움. 대신 lombok
//getter setter는 사용을 지양하는 게 좋은듯......?
//컴파일시에 데이타 붙은곳에 getter setter toString HashCode드 등등 자동 생성함 
//나중에 jpa,쓸때 toString 때문에 오류터지니까 명시적으로 필요한거만 골라서 쓰는거 추천
//setter는 순환참조문제도 있어서 안쓰는게 좋은 듯. setter 하면 private로 선언하는 의미가 없는 것 같다

@Data
public class Book {

	private String bookCode;
	private String bookTitle;
	private String author;
	private String press;
	private int price;

	Book() {

	}

	public Book(String bookCode, String bookTitle, String author, String press, int price) {
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.author = author;
		this.press = press;
		this.price = price;

	}

	// 메소드 정의.

	void showInfo() {
		System.out.println(this.bookCode + " " + this.bookTitle + " "+ this.author + " " + this.press + " " + this.price); // 앞에 this 왜 붙여준거지??
		
	}
} //end of class
