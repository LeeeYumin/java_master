package remind6;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		boolean run = true;

		Student[] students = new Student[100];

		Scanner scn = new Scanner(System.in);
		StudentExe exe = new StudentExe();
		while (run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제.6.종료");
			int menu = Integer.parseInt(scn.nextLine()); // 숫자로만 선택가능

			switch (menu) {
			case 1:
				System.out.println("학생 번호 입력>> ");
				String stuNo = scn.nextLine();
				System.out.println("학생 이름 입력>> ");
				String stuName = scn.nextLine();
				System.out.println("영어 점수 입력>> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.println("수학 점수 입력>> ");
				int math = Integer.parseInt(scn.nextLine());

				Student std = new Student(stuNo, stuName, eng, math); // public Student 타입 맞아야 오류X
				// 4가지 값을 다 받는 생성자. students 배열에 한건 저장
//				for (int i=0; i < students.length; i++) {
//					if(students[i] == null) {
//						students[i] = std;
//						break;
//					}
//				}
				if (exe.addStudent(std)) {
					;
					System.out.println("저장되었습니다");
				} else {
					System.out.println("저장 중 오류");
				}
				break;
			case 2: // 목록보기
//				for (int i=0; i < students.length; i++) {
//					if(students[i] != null) {
//						students[i].showInfo();
//					}
//				}
				//Student[] stdAry = exe.getStudentList(); 두개가 같다.
				//그래서 밑에 exe.getStudentList() 대신 stdAry넣어도 됨.
				for (Student stdnt : exe.getStudentList()) {
					if (stdnt != null) {
						stdnt.showInfo();
					}
				} // Student[]타입
				break;
			case 3: // 단건조회
				System.out.println("조회할 학생 번호 입력>> ");
				stuNo = scn.nextLine();
//				for(int i=0; i < students.length; i++) {
//					if(students[i] != null && students[i].getStuNo().equals(stuNo)) {
//						 students[i].showInfo();
//					}
//				}
				Student stnt = exe.getStudent(stuNo);
				if (stnt != null) {
					stnt.showInfo();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;
			case 4: // 수정 학생 번호를 넣고 영어, 수학 바꿔주기
//				boolean exists = false;
				System.out.println("수정할 학생 번호 입력>> ");
				stuNo = scn.nextLine();
				System.out.println("영어 점수 입력>> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.println("수학 점수 입력>> ");
				math = Integer.parseInt(scn.nextLine());
//				for (int i = 0; i < students.length; i++) {
//					if (students[i] != null && students[i].getStuNo().equals(stuNo)) {
//					System.out.println("영어점수 입력");
//					students[i].setEng(Integer.parseInt(scn.nextLine()));
//					System.out.println("수학점수 입력");
//					students[i].setMath(Integer.parseInt(scn.nextLine()));
//					exists = true;
//					System.out.println("수정완료");
//					}
//				}
//				if (!exists) {
//					System.out.println("존재하지 않는 정보");
				if(exe.modifyStudent(stuNo, eng, math)) {
					System.out.println("수정완료");
				}else{
					System.out.println("수정실패");
				}
				break;
			case 5: // 삭제 해당되는 값 null로 바꿔주기
//				exists = true;
				System.out.println("삭제할 학생 이름 입력>> ");
				stuName = scn.nextLine();
				if (exe.removeStudent(stuName)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
				break;
			case 6: // 종료
				System.out.println("프로그램을 종료합니다");
				run = false;

			}
		} // end of while
		System.out.println("end of prog");

	}

}
