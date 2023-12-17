package com.yedam;
//관리자 담는 클래스...

import lombok.Data;

@Data

public class Admin {
	
	private int cuser;
	private String cname;
	private int pnumber;
	private String pname;
	private int pprice;
	private int dnumber;
	private String dname;
	private int dprice;
	private int take;
	
	Admin(){
		
	}
	
	public Admin(int cuser, String cname, int pnumber, String pname, int pprice, int dnumber, String dname, int dprice, int take) {
		this.cuser = cuser;
		this.cname = cname;
		this.pnumber = pnumber;
		this.pname = pname;
		this.pprice = pprice;
		this.dnumber = dnumber;
		this.dname = dname;
		this.dprice = dprice;
		this.take = take;
	}
	
	void showInfo() {
		System.out.println(cuser + cname + take +
					"\n" + pnumber + pname + pprice + 
					"\n" + dnumber + dname + dprice);
	
	}



} //end of class
