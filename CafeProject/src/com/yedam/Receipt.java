package com.yedam;

//Member 개인 주문 이력 조회

import lombok.Data;

@Data
public class Receipt {

	int cuser;
	String cname;
	String pname;
	String dname;
	String take;

	String showInfo() {
		return this.cname + " : " + this.pname + ", " + this.dname + " / " + this.take;
	}
} //  end of class
