package com.yedam;
//회원

import lombok.Data;

@Data

public class Member {

	private int cuser;
	private String cname;

	Member() {

	}

	public Member(int cuser, String cname) {
		this.cuser = cuser;
		this.cname = cname;
	}

	void showInfo() {
		System.out.println(this.cuser + " , " + this.cname);
	}

} // end of class
