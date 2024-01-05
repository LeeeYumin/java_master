package com.yedam.student.vo;

public class Student {
	// 필드정의.
	private String studentNumber; // student_number
	private String studentName;
	private int englishScore;
	private int mathmaticScore;

	// 생성자정의.
	public Student() {
	}

	public Student(String studentNumber, String studentName, int englishScore, int mathmaticScore) {
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.englishScore = englishScore;
		this.mathmaticScore = mathmaticScore;
	}

	// 메소드 정의.
	public void showInfo() {
		System.out.println("이름은 " + studentName + ", 영어점수는 " + englishScore + ", 수학점수는 " + mathmaticScore + "입니다.");
	}

	// getter.
	public String getStudentNumber() {
		return studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathmaticScore() {
		return mathmaticScore;
	}

	// setter.
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public void setMathmaticScore(int mathmaticScore) {
		this.mathmaticScore = mathmaticScore;
	}

}
