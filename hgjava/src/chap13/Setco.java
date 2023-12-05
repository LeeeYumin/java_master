package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Setco {
	public static void main(String[] args) {
		
		//hashSet
		//Set<E> set = new HashSet<E>();
		Set<String> set = new HashSet<String>();
		//Set<String> set = new HashSet<>();
		
		//568예제
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java"); //"Java"는 1번만 저장됨
		set.add("iBATIS");
		
		int size = set.size();
		System.out.println("총 객체수 : " + size);
		
		Iterator<String> iterator = set.iterator(); //반복자 얻기
		while(iterator.hasNext()) { //객체 수만큼 돌기
			String element = iterator.next(); //객체 1개 가져옴
			System.out.println("\t" + element);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS"); //객체 2개 삭제
		
		System.out.println("총 겍체수 : " + set.size());
		
		iterator = set.iterator();
		for(String element : set) {
			System.out.println("\t" + element);
		}
		
		set.clear();
		if(set.isEmpty()) {System.out.println("빔");}
		
		
	} //end of main
} //end of class
