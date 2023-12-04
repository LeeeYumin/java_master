package chap11.object;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		//1:YEAR, 2:MONTH, DAY_OF_WEEK:일(1)월(2)...토(7)
		Calendar cal = Calendar.getInstance();
		cal.set(1, 2022); //년
		cal.set(Calendar.MONTH, 4); //5월
		System.out.println(Calendar.MONTH); //이렇게도 확인가능
		cal.set(Calendar.DATE, 1); //일
		cal.set(2023, 2, 1); //위의 4줄을 1줄로 요약가능
		System.out.println("요일: " +cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("막날: " + cal.getActualMaximum(Calendar.DATE));
	}
}
