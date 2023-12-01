package chap11.object;

import java.util.HashSet;

public class HashSetExe {
	public static void main(String[] args) {
		// 배열은 null값 처리 등의 단점을 보완하는 컬렉션 사용.
		//(List 인덱스값이용, Set 중복된건안받는데이터구조, Map key 와 value 로 구분)
		HashSet<String> set = new HashSet<String>(); //어떤 형태를 잡겠다~ <>안에 적음.
		set.add("Hong");
		set.add("Hwang");
		set.add("Park");
		set.add("Hong");
		//set.add(new Member("Hong", 20)); 이런건 못받음. String 만 받겠다고 위에서 해놨기때문에!
		
		//set : 중복된 값은 제거.
		for (Object name : set) {
			System.out.println(name);
		}
		
		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("김길동", 21));
		members.add(new Member("박길동", 22));
		members.add(new Member("홍길동", 20));
		
		for(Member mem : members) {
			System.out.println(mem.toString());
		}
		
	} //end of main
} //end of class
