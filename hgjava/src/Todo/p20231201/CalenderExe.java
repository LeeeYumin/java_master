package Todo.p20231201;

import java.util.Calendar;

public class CalenderExe {
	public static void main(String[] args) {
		int year = 2023;
		int month = 8;

		System.out.println(year + "년 " + month + "월 달력");

		Calendar today = Calendar.getInstance();

		// 10월 달력. 12월은 Sun에 1일부터 시작인데 금요일에 1일이 오게 수정해보기(앞에 5일은 공백으로)
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, (month - 1));
		today.set(Calendar.DATE, 1);

		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };

		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();

		// 빈공백설정
		int spaces = today.get(Calendar.DAY_OF_WEEK)-1;//1이 일요일. 2가 월요일. 6-1은 5.
		for (int i = 0; i < spaces; i++) {
			System.out.printf("%4s", "");
		}

		int lastDays = today.getActualMaximum(Calendar.DATE);
//		for (int i = 1; i <= lastDays; i++) {
//			System.out.printf("%4s", "");
//		} 필요없... 주석유지... 교수님 적은거 일부분인데 틀리게 썼을 가능성 높음

//		private void printDates() {
//			
//			int endDate = cal.getActualMaximum(Calendar.DATE);
//			for (int i = 1; i <= endDate; i++) {
//				
//				cal.set(Calendar.DATE, i);
//				System.out.print(i + "\t");
//			}
//		} 이건

		for (int i = 1; i <= lastDays; i++) {
			System.out.printf("%4d", i);
			if ((i+spaces) % 7 == 0) { //i는 2고 spaces는 5. 7일 기준으로 잘라야해서 i % 7 == 0
				System.out.println();
			}
		}
		System.out.println("\n == the end ==");
	} // end of main

} // end of class
