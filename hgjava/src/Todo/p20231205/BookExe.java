package Todo.p20231205;

import java.util.ArrayList;

//도서실행. 등록 목록 수정 삭제 기능 컬렉션 적용
public class BookExe {

	private ArrayList<Book> books; //ArrayList가 클래스.

	// 생성자
	BookExe() {
		books = new ArrayList<Book>();
		books.add(new Book("B001", "이것이 자바다", "신용권", "한빛미디어", 25000));
		//books[1] = new Book("C003", "자바 기초", "김재원", 20000);
		//books[2] = new Book("D001", "자바 마스트", "박재민", 15000);
	}

	boolean addBook(Book book) {
		return books.add(book); //1건 추가
	}

	// 목록
	ArrayList<Book> getBookList() {
		return books; // books는 배열이름
	}

	// 단건조회
	Book getBook(String bCode) {
	for (int i = 0; i < books.size(); i++) {		
		if (books.get(i) != null && books.get(i).getbCode().equals(bCode)) {		
			return books.get(i); //컬렉션에서 한건 들고 옴		
		}		
	}
	return null; //없으면 null 반환
	}
	
	//수정
	boolean modifyBook(String bCode, int price) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null && books.get(i).getbCode().equals(bCode)) {
				books.get(i).setbCode(bCode);
				return true;
			}
		}
		return false;
	}
	//삭제
	boolean removeBook(String bCode) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i) != null && books.get(i).getbCode().equals(bCode)) {
				books.remove(i);
				return true;
			}
		}
		return false;
	}
} // end of class
