package selftest2;

import java.util.ArrayList;
import java.util.Scanner;

//1.상품관리 2.입출고관리 3.종료
//1-1)등록 1-2)수정 1-3)목록
//2-1)판매 2-2)구매 2-3)재고
//->재고 상품코드 재고수량
//       P001 5(개)
//       P002 3(개)
//       N001 10(개)
//       N002 12(개)

public class ProductApp {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		ProductExe exe = new ProductExe(); // 위에서 이렇게 선언 해줘야 밑에서 적용됨

		while (run) {
			System.out.println("1.상품관리 2.입출고관리 3.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("1.등록 2.수정 3.목록");
				int a = scn.nextInt(); scn.nextLine();
				// 2개 해줘야 상품코드, 상품이름 동시에 입력안되게 해줌.
				// nextInt() 만 해주면 코드, 이름 동시에 입력창 뜸.
				if (a == 1) {
					System.out.println("상품코드 입력>> ");
					String pCode = scn.nextLine();
					System.out.println("상품이름 입력>> ");
					String pName = scn.nextLine();
					System.out.println("가격 입력>> ");
					int pPrice = Integer.parseInt(scn.nextLine());
					exe.addProduct(new Product(pCode, pName, pPrice));
				} else if (a == 2) {
					System.out.println("상품코드 입력>> ");
					String pCode = scn.nextLine();
					System.out.println("가격 입력>> ");
					int pPrice = Integer.parseInt(scn.nextLine());
					exe.modifyProduct(pCode, pPrice);
				} else {
					ArrayList<Product> list = exe.getProductList();
					for (int i = 0; i < list.size(); i++) {
						list.get(i).showInfo();
					}
				}
				break;
			case 2: //InOut에서 가져와야하는듯...? 보류,,,
				System.out.println("1.판매 2.구매 3.재고");
				int b = scn.nextInt(); scn.nextLine();
				if (b == 1) {
					System.out.println("상품코드 입력>> ");
					String pCode = scn.nextLine();
					System.out.println("상품이름 입력>> ");
					String pName = scn.nextLine();
					System.out.println("가격 입력>> ");
					int pPrice = Integer.parseInt(scn.nextLine());
					exe.addProduct(new Product(pCode, pName, pPrice));
				} else if (b == 2) {
					System.out.println("상품코드 입력>> ");
					String pCode = scn.nextLine();
					System.out.println("가격 입력>> ");
					int pPrice = Integer.parseInt(scn.nextLine());
					exe.modifyProduct(pCode, pPrice);
				} else {
					ArrayList<Product> list = exe.getProductList();
					int sum = 0;
					for (int i = 0; i < list.size(); i++) {
						sum += i;
						list.get(i).showInfo();
					}
				}
				break;
			case 3:
				System.out.println("종료");
				run = false;
			} // switch

		} // while

		System.out.println("end of prog");

	} // end of main

} // end of class
