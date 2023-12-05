package remind7;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		StudentExe exe = new StudentExe();

		boolean run = true;

		Student[] students = new Student[100];

		while (run) {

			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {

			case 1:

				System.out.println("학생번호입력>>");

				String no = scn.nextLine();

				System.out.println("학생 이름 입력");

				String name = scn.nextLine();

				System.out.println("영어 점수 입력");

				int eng = Integer.parseInt(scn.nextLine());

				System.out.println("수학 점수 입력");

				int mat = Integer.parseInt(scn.nextLine());

				Student std = new Student(no, name, eng, mat);

				if (exe.addStudent(std)) {

					System.out.println("저장 되었습니다.");

				} else {

					System.out.println("저장 중 오류 발생");

				}

				break;

			case 2: // 목록보기

				for (Student stdnt : exe.getStudentList()) {

					if (stdnt != null) {

						stdnt.showInfo();

					}

				}

				for (int i = 0; i < students.length; i++) {

					if (students[i] != null) {

						students[i].showInfo();

					}

				}

				break;

			case 3:// 단건 조회

				System.out.println("조회할 학생 번호 입력");

				no = scn.nextLine();

				Student stnt = exe.getStudent(no);

				if (stnt != null) {

					stnt.showInfo();

				} else {

					System.out.println("존재하지 않는 정보");

				}

				break;

			case 4: // 수정

				System.out.println("조회할 학생 번호 입력>>");

				no = scn.nextLine();

				System.out.println("영어점수 입력>>");

				eng = Integer.parseInt(scn.nextLine());

				System.out.println("수학 점수 입력");

				mat = Integer.parseInt(scn.nextLine());

				if (exe.modifyStudent(no, eng, mat)) {

					System.out.println("수정 완료");

				} else {

					System.out.println("수정 실패");

				}

				break;

			case 5:// 삭제

				System.out.println("삭제할 학생 이름 입력>>");

				name = scn.nextLine();

				if (exe.removeStudent(name)) {

					System.out.println("삭제완료");

				} else {

					System.out.println("삭제 실패");

				}

				break;

			case 6:

				System.out.println("프로그램을 종료합니다");

				run = false;

			}// end of switch

		} // end of while

		System.out.println("end of prog");

	}// end of main



}