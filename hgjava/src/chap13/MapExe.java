package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
		//키:값 쌍으로 구성
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//추가
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("이유민", 95);
		map.put("홍길동", 95); //("key",value)
		
		//값 가져오기. 키값반환
		Integer result = map.get("홍길동");
		
		//전체 목록 가져오기
		Set<String> set = map.keySet(); //키값만 가져와서 set<>형태의 데이터 타입으로.
		for(String key : set) {
			System.out.println("key: " + key + ", value : " + map.get(key));
		}
		
	}//end of main

}//end of class
