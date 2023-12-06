package selftest2;
//판매정보
//상품코드/처리날짜/수량/판(구)매
//==========================
//P001 2023-12-06 10 구매
//P001 2023-12-06  2 판매
//P001 2023-12-06  3 판매

public class InOut {
	private String sell;
	private String buy;
	private int stock;
	
	InOut(){
		
	}
	
	public InOut(String sell, String buy, int stock) {
		this.sell = sell;
		this.buy = buy;
		this.stock = stock;
	}

	String getSell() {
		return sell;
	}

	void setSell(String sell) {
		this.sell = sell;
	}

	String getBuy() {
		return buy;
	}

	void setBuy(String buy) {
		this.buy = buy;
	}

	int getStock() {
		return stock;
	}

	void setStock(int stock) {
		this.stock = stock;
	}
	
	void showInfo() {
		System.out.println();
	}
	
} //end of class
