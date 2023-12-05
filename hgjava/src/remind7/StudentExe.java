package remind7;

//저장공간: 배열

// 추가/수성/삭제/목록/단건조회

public class StudentExe {

	// 배열:

	private Student[] students;

	// 배열 필드
	// 생성자 생성자는 반환 타입이 없음 이름만 있으면 된다

	StudentExe() {

		students = new Student[100];

		// 필드

	}

	// 추가. 매개값

	boolean addStudent(Student std) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = std;
				// break;
				return true; // 메소드에서 return문 메소드의 끝.
			}
		}
		return false;
	}



	// 목록.
	Student[] getStudentList() {
		return students;
	}


	// 단건조회
	Student getStudent(String no) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudNo().equals(no)) {
				return students[i];
			}
		}
		return null;
	}


	// 수정.
	boolean modifyStudent(String no, int eng, int mat) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudNo().equals(no)) {
				students[i].setEngScore(eng);
				students[i].setMathScore(mat);
				return true;
			}
		}
		return false;
	}


	// 삭제
	boolean removeStudent(String name) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudName().equals(name)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}

} //end of class
