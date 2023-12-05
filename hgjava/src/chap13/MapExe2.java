package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member,String> map; //문자열이 키로 가고 Member가 value로 갈수도있음
		map = new HashMap<>();
		
		map.put(new Member("M001", "홍길동", 100), "경기도 100번지");
		map.put(new Member("M002", "김민수", 90), "서울시 200번지");
		map.put(new Member("M003", "박씨", 80), "대전시 300번지");
		map.put(new Member("M001", "홍길동", 100), "경기도 200번지");
		
		map.remove(new Member("M001", "홍길동", 100)); //삭제
		
		//중복된 값은 담아주지 않는 set 컬렉션
		//1)key를 set에 저장해서 가져온다
		Set<Member> set = map.keySet();
		for(Member member : set) { //member는 키역할
			//System.out.println(member.toString());
			System.out.println("key: " + member + ",value:" + map.get(member));
		}
		//2)key 와 value를 set 에 저장하는 방법
		Set<Entry<Member, String>> entry = map.entrySet();
		for (Entry<Member, String> ent : entry) {
			System.out.println("key: " + ent.getKey() + ",val:" + ent.getValue());
		}
		
	}//end of main

}//end of class
