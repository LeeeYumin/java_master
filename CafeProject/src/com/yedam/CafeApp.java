package com.yedam;
//실행

import java.util.Scanner;

public class CafeApp {

	public static void main(String[] args) {
		CafeDAO dao = new CafeDAO();
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		
		
		while (run) {
			System.out.println("1.주문자번호 2.음료 3.디저트 4.주문자정보");
			System.out.println("포장 : 1번, 매장 취식 : 2번");
			int num = Integer.parseInt(scn.nextLine());
			if(dao.grade1(num)) {
				
			}else {
				
			}
			
			
		}
		
	}
	
	
} //end of class
