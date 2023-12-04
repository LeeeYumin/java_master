package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		String[] strs = { "Mon", "Tue", "10" };
		strs[0] = "Wed"; //"Wed" 대신 null 넣으면 삭제의 의미?
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}

		List<String> list = new ArrayList<String>();
		list.add("");
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		
		list.remove("Apple"); //삭제. 공간은 비워져있음.
		list.set(0, "바나나"); //첫번째 위치에 있는 값을 변경
		list.clear(); //전체 요소 삭제. 배열에 있는거만 남고 나머지는 지워짐.
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//컬렉션의 크기 변경.
		for(int i = 0; i < 100; i++) {
			list.add("" + i);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)); //0에서 99까지 출력됨
		}
		
		//이름이 저장
		List<String> names = new ArrayList<String>();
		names.add("홍길동"); //인덱스값 0 : 첫번째
		names.add("김길동"); //1 : 두번째
		names.add("박철수"); //2 : 세번째
		
		String search = "길동";
		int cnt = 0;
		for (int i = 0; i<names.size(); i++) { // size() : Collection이름.size(). 자료구조의 크기를 알려 할 때
			if(names.get(i).indexOf(search) != -1) { //equals 말고 indexOf 사용도 가능.get메소드 사용해서 구해봄.
				cnt ++;
			}
		} System.out.println(search + "은 " + cnt + "명 입니다");

	} //main
} //end of class
