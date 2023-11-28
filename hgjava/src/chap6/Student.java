package chap6;

public class Student {
	//학생번호 23-001, 23-002 getStudNo 이런식으로
	//학생이름(홍길동, 박씨) - 필드
	//영어, 수학 - 필드
	//method : showInfo(), 학생이름, 영어, 수학
	
	//학생앱에서 이어 작업
	
	String stuNo;
	String stuName;
	int eng;
	int math;

	public Student(String stuNo, String stuName, int eng, int math) { 
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.eng = eng;
		this.math = math;					
}	
	//setter 대입해서 넣어주는거 void 뜻 : 리턴값이없음
	void setstuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	
	void setStuName(String stuName) {
		this.stuName = stuName;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	void setMath(int math) {
		this.math = math;
	}
	
	//getter로 가져옴 return으로 있는 값을 들고 오는 것. ()까지 같이 써줘야함
	String getStuNo() {
		return stuNo;
	}
	String getStuName() {
		return stuName;
	}
	int getEng() {
		return eng;
	}
	int getMath() {
		return math;
	}
	
	void showInfo() { 
		System.out.println("이름은 " + stuName + "이고 " + "영어는 " + eng + "점, 수학은 " + math + "점 입니다.");
}
}