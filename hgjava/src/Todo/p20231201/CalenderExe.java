package Todo.p20231201;
//과제
public class CalenderExe {
	public static void main(String[] args) {
		//12월 달력. Sun에 1일부터 시작인데 금요일에 1일이 오게 수정해보기(앞에 5일은 공백으로)
		String [] days = {"Sun", "Mon", "Tue","Wed","Thr","Fri", "Sat"};
		
		for(String day : days) {
			System.out.printf("%4s" ,day);
		}
		System.out.println();
		
		//빈공백설정
		for (int i = 0; i < 5; i++) {
			System.out.printf("%4s" ,"");
		}
		
 		for (int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if(i % 7 == 0) { //7일 기준으로 잘라야됨. i % 7 == 0
				System.out.println();
			}
		}
		System.out.println(" == the end ==");
	}
	
	
	
} //end of class
