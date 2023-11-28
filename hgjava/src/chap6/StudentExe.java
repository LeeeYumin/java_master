package chap6;
//저장공간 : 배열

//추가/수정/삭제/목록/단건조회

public class StudentExe {
	// 배열 :
	private Student[] students;

	// 생성자 : 반환타입없음
	StudentExe() {
		students = new Student[100]; // 필드 = new ~
		students[0] = new Student("23-001", "홍길동", 77, 88);
		students[1] = new Student("23-002", "김철수", 82, 85);
	}

	// 추가
	boolean addStudent(Student std) { // ()안은 매개변수? 매개값?
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = std;
//				break;
				return true; // 메소드 안에서 리턴구문은 메소드의 끝임
			}
		}
		return false; // 반환안되면 false
	}

	// 목록
	Student[] getStudentList() {
		return students;
	}

	// 단건조회
	Student getStudent(String no) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuNo().equals(no)) {
				return students[i];
			}
		}
		return null;
	}

	// 수정
	boolean modifyStudent(String no, int eng, int math) { // void->boolean
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuNo().equals(no)) {
				students[i].setEng(eng);
				students[i].setMath(math);
				return true; // 잘 반환되면 true
			}
		}
		return false; // 아님 false
	}

	// 삭제
	boolean removeStudent(String name) { 
		for(int i=0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuName().equals(name)) {
				students[i] = null;
				return true; 
			}
		return false; 
		}	
	}
	}
}
