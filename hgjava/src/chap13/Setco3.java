package chap13;

//import java.util.HashSet;
//import java.util.Set;
import java.util.*;

public class Setco3 {

	public static void main(String[] args) {

		Set<Member> set = new HashSet<Member>();

		//set.add(new Member("홍길동", 30));
		//set.add(new Member("홍길동", 30)); 인스턴스는 다르지만 내부 데이터는 동일. 객체 1개만 저장됨.

		System.out.println("총 객체수 : " + set.size()); //총 객체수는 1.

	}

}
