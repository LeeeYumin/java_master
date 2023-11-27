package chap5;

import java.util.Scanner;

public class StudentApp2 { //메소드는 클래스 안에 있어야 한다
	static Scanner scn = new Scanner(System.in);
	static Student[] students = null;
	
	public static void addStudent() {
		System.out.println("학생정보 입력>> ");
		for(int i=0; i<students.length; i++) {
			Student student = new Student(); //Student는 데이터타입. student는 변수 이름. 클래스는 new 붙여서 변수 선언. ctrl클릭하면 상세로 볼수있음
			System.out.println("학생 이름 입력>> ");
			student.name = scn.nextLine();  
			System.out.println("학생 점수 입력>> ");
			student.score = Integer.parseInt(scn.nextLine()); //Student.java(클래스?)에 제대로 안적으면 에러남
			System.out.println("남/여 입력>> ");
			student.gender = scn.nextLine(); 
			
			students[i] = student;
		}
	} //end of addStudent()
	
	public static void searchStudent() {
		System.out.print("조회할 이름 입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		//학생이름 - 점수 출력 형태
		for(Student stdn : students) {
			if(name.equals(stdn.name)) {
			System.out.println("이름은 " + stdn.name + ", 점수는 "  + stdn.score);
			exists = true;
			}
		}
		//찾는 이름의 존재여부 : exists 를 확인. //앞에서 입력한 3명의 이름이 있는지의 여부임.
		if (!exists) {
			System.out.println("찾는 이름이 없습니다.");
		}	
	} //end of searchStudent()
	
	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student stn : students) {
			if(stn.gender.equals("남")) { //남자 라고 쓰면 제외됨.
				sumOfMen += stn.score;
				cntOfMen++;
			} else if (stn.gender.equals("여")) {
				sumOfWomen += stn.score;
				cntOfWomen++;
			}
		}
		System.out.println("남학생의 평균: " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("여학생의 평균: " + (sumOfWomen * 1.0 / cntOfWomen));
	} //end of analysis()
	
	public static void modify() {
		//이름입력 -> 변경점수.
		System.out.print("조회할 이름 입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		for (int i = 0; i < students.length; i++) {
			//조건추가 => 변경점수 입력.
				
		
			System.out.println();
		}
		//찾는 이름이 없음
		
	} //end of modify()
	public static void main(String[] args) {
		boolean run = true;
		
		int studentNum = 0; 
		
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.수정 6.종료");
			int menu = scn.nextInt(); //3Enter
			scn.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println("학생수 입력>> ");
				studentNum = Integer.parseInt(scn.nextLine()); //"3"을 3으로 바꿔줌
				students = new Student[studentNum];
				break;
			case 2:
				addStudent();			
				break;
			case 3:
				searchStudent();		
				break;		
			case 4: //System.out.println("분석>> ");
				analysis();
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("종료합니다");
				run = false;
				
			}

	}//end of while

}// end of main
}// end of class