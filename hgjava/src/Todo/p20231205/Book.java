package Todo.p20231205;
//도서정보. 도서코드/도서명/저자/출판사/가격 정보 저장
public class Book {

	private String bCode;
	private String bName;
	private String writer;
	private String bCom;
	private int price;
	
	//생성자 정의
	Book(){
		
	}
	
	public Book(String bCode, String bName, String writer, String bCom, int price) {
		this.bCode = bCode;
		this.bName = bName;
		this.writer = writer;
		this.bCom = bCom;
		this.price = price;
	}

	//get set 메소드
	String getbCode() {
		return bCode;
	}

	String getbName() {
		return bName;
	}

	String getWriter() {
		return writer;
	}

	String getbCom() {
		return bCom;
	}

	int getPrice() {
		return price;
	}

	void setbCode(String bCode) {
		this.bCode = bCode;
	}

	void setbName(String bName) {
		this.bName = bName;
	}

	void setWriter(String writer) {
		this.writer = writer;
	}

	void setbCom(String bCom) {
		this.bCom = bCom;
	}

	void setPrice(int price) {
		this.price = price;
	}
	
	//메소드
	void showInfo() {
		System.out.println(bCode + " " + bName + " " + writer + " " + bCom + " " + price);
	}
	
	
}
