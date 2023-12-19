package com.yedam;

//Member 개인 주문 이력 조회

import lombok.Data;

@Data
public class Receipt {

	int cuser;
	String cName;
	String pName;
	String dName;
	String take;

	String showInfo() {
		return this.cName + " : " + this.pName + ", " + this.dName + " / " + this.take;
	}
} // end
