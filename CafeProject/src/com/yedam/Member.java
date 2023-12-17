package com.yedam;
//회원

import lombok.Data;

@Data

public class Member {

	private int cuser;
	private String cname;
	private int pnumber;
	private String pname;
	private int dnumber;
	private String dname;
	private int take;
	
	Member(){
		
	}
	public Member(int cuser, String cname, int pnumber, String pname, int dnumber, String dname, int take) {
		this.cuser = cuser;
		this.cname = cname;
		this.pnumber = pnumber;
		this.pname = pname;
		this.dnumber = dnumber;
		this.dname = dname;
		this.take = take;
		
	}
	
	void showInfo() {
		System.out.println(this.cuser + " , " + this.cname + " , " + this.pnumber + " : " +  this.pname + " , " + this.dnumber + " : " + this.dname + " / " + this.take);
	}

	
	
	
	
} //end of class
