package chap13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TodoExe {
	public static void main(String[] args) {
		// 순번(단순하게 번호), 할일(Todo) dueDate추가하면 2개 값으로 만들어야 함..
		Map<Integer, Todo> todoList = new HashMap<>();

		Scanner scn = new Scanner(System.in);

		while (true) { // true 하면 무한반복
			System.out.println("번호 할일 기한>>");
			String input = scn.nextLine(); // 20 장보기 23-12-08 없으면 오늘 날짜(엔터)
			String[] inpAry = input.split(" ");

			// 걸러낼 조건.
			if (inpAry.length != 2 && inpAry.length != 3) {
				System.out.println("입력값을 확인하세요");
				continue;
			}
			String order = inpAry[0]; // 순번
			String title = inpAry[1]; // 할일제목

			Todo todo = null;
			if (inpAry.length == 2) {
				todo = new Todo(title);
			} else if (inpAry.length == 3) {
				String dueDate = inpAry[2]; // null 인지 아닌지 체크
				// Date -> String 또는 String -> Date 로
				// 2023-10-23 => format
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					todo = new Todo(title, sdf.parse(dueDate)); // dueDate는 문자열
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			todoList.put(Integer.parseInt(order), todo);
			if (todoList.size() == 5) {
				break;
			}
		} //while

		// 순번, 할일 출력.
		System.out.println("번호   할일  DueDate");
		System.out.println("==================");
		Set<Entry<Integer, Todo>> entry = todoList.entrySet();
		for (Entry<Integer, Todo> ent : entry) {
			System.out.println(ent.getKey() + " " + ent.getValue().toString());
		}
		// }return false;
		System.out.println("end of prog");

	} // end of main
} // end of class
