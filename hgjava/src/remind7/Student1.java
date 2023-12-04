package remind7;

public class Student1 {

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

	// getter로 가져옴 return으로 있는 값을 들고 오는 것. ()까지 같이 써줘야함
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
