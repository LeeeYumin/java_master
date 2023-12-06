package selftest2;

public class Product {

	private String pCode;
	private String pName;
	private int pPrice;
	//private int stock;
	//private String sell;
	//private String buy;

	Product() {

	}

	public Product(String pCode, String pName, int pPrice) {
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		
	}

	String getpCode() {
		return pCode;
	}

	void setpCode(String pCode) {
		this.pCode = pCode;
	}

	String getpName() {
		return pName;
	}

	void setpName(String pName) {
		this.pName = pName;
	}

	int getpPrice() {
		return pPrice;
	}

	void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
	void showInfo() {
		System.out.println(pCode + " " + pName + " " + pPrice);
	}
	

}// end of class
