package com.yedam;

import lombok.Data;

@Data

public class Product {
	
	int pnumber;
	String pname;
	int pprice;
	int dnumber;
	String dname;
	int dprice;
	String take;
	
	Product(){	
	}
	
	public Product(int pnumber, int dnumber, String take) {
		this.pnumber = pnumber;
		this.dnumber = dnumber;
		this.take = take;
	}
	
	public Product(int pnumber, String pname, int pprice, int dnumber, String dname, int dprice, String take) {
		this.pnumber = pnumber;
		this.pname = pname;
		this.pprice = pprice;
		this.dnumber = dnumber;
		this.dname = dname;
		this.dprice = dprice;
		this.take = take;
	}
	

	void showInfo() {
		System.out.println(this.pnumber + " : " + this.pname + " , " + this.pprice  + 
				   " /n" + this.dnumber + " : " + this.dname + " , " + this.dprice +
				   "/'n" + this.take);
	}
	
	
}//end
