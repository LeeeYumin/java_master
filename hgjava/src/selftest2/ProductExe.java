package selftest2;

//상품등록/상품(가격)수정/상품목록
import java.util.ArrayList;

public class ProductExe {

	private ArrayList<Product> products;

	ProductExe() {
		products = new ArrayList<Product>();
		products.add(new Product("P001", "볼펜", 1000));
		products.add(new Product("P002", "연필", 1200));
		products.add(new Product("N001", "노트100", 1000));
		products.add(new Product("N001", "다이어리", 3000));
	}

	boolean addProduct(Product product) {
		return products.add(product);
	}

	boolean modifyProduct(String pCode, int pPrice) { //하나를 더 가져와서 그걸로 찾고 가격 수정을 해야하니 총 2개 들고와야 함
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getpCode().equals(pCode)) { //배열아니라서 != null 안써도 됨
				products.get(i).setpPrice(pPrice); //~라면 set 값 가져오기
				return true;
			}
		}
		return false;
	}

	ArrayList<Product> getProductList() {
		return products;
	}
	

} // end of class
