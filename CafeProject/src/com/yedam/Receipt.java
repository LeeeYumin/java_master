package com.yedam;
//Member의 개인 주문 이력 조회
public class Receipt {

	int cuser;
	String pname;
	String dname;
	
	Receipt(){
		
	}
	
	public Receipt (int cuser, String pname, String dname) {
		this.cuser = cuser;
		this.pname = pname;
		this.dname = dname;
	}
	
	void showInfo() {
		System.out.println(this.cuser + " : " + this.pname + " ," + this.dname);
	}
	
} //end
