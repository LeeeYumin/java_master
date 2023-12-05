package selftest;

public class Emp {

	String sNum;
	String sName;
	int sPhone;
	int dateCom;
	int salary;
	
	public Emp(String sNum, String sName, int sPhone, int dateCom, int salary) {
		this.sNum = sNum;
		this.sName = sName;
		this.sPhone = sPhone;
		this.dateCom = dateCom;
		this.salary = salary;
	}
	
	
	//getter setter	
	String getsNum() {
		return sNum;
	}

	String getsName() {
		return sName;
	}

	int getsPhone() {
		return sPhone;
	}

	int getDateCom() {
		return dateCom;
	}

	int getSalary() {
		return salary;
	}


	void setsNum(String sNum) {
		this.sNum = sNum;
	}


	void setsName(String sName) {
		this.sName = sName;
	}


	void setsPhone(int sPhone) {
		this.sPhone = sPhone;
	}


	void setDateCom(int dateCom) {
		this.dateCom = dateCom;
	}


	void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
} //end of class
