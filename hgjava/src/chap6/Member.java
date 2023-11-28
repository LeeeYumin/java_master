package chap6;
// 회원관리 앱
// 회원번호, 회원이름, 연락처, 성별
// public <-> private 접근 수준 public은 다른 클래스에서 접근 가능.

public class Member {
	//1. 속성(필드)
	private int memberNo; //자바에서는 두~세단어이상의 조합 : CamelCase.
	private String memberName;
	private String phone; //010-1234-5667
	private String gender; //Men of Women 을 M, W으로 하면 X.
	
	//2. 생성자 - 생성자는 반드시 있음. 필드의 초기값을 지정하는 역할.
	//기본생성자 - 컴파일러가 생성해줌 (매개값이 없는것. 따로 정의 안하면 컴파일러가 기본생성자로 해줌)
	Member(){
		
	}
	Member(int memberNo, String memberName){ //매개값2개가짐. mem2
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
		
	public Member(int memberNo, String memberName, String phone, String gender) { //mem3
		//source-Generate Constructor using fields에서 들어감
		super(); //super는 상속개념. 지금은 없어도 상관무
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}
	
	//3. 기능(메소드) 1~3이 클래스멤버임.
	void showInfo() { //void : 반환되는 값의 유형
		System.out.println("이름은 " + memberName + "이고 연락처는 " + phone + "입니다.");
	}
	
	String showAllInfo() {
		String result = "이름은" + memberName + "이고 번호는" + memberNo + "이고 연락처는" + phone+ "이고 성별은" + gender + "입니다";
		return result; //문자열을 반환하겠다는 의미
	}
	
	// memberNo의 값을 지정하는 메소드
	void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}	
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	
	//getter
	int getMemberNo() {  //int를 반환해오는 메소드
		return memberNo;
	}
	String getMemberName() {
		return memberName;
	}
	String getPhone() {
		return phone;
	}
	String getGender() {
		return gender;
	}
	
}
