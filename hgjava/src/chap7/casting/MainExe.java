package chap7.casting;

public class MainExe {
	public static void main(String[] args) {
		
		double d1 = 100; //내부적으로 자동형변환이 되는 케이스
		//int n1 = 100.0; //자동형변환 안되는 케이스
		int n1 = (int) 100.0; //형변환 이렇게 해주면 되는데 값은 잃음
		
		
		//promotion (자동형변환)
		Parent p1 = new Child(); 
		
		//casting (강제형변환)
		//Child c1 = (Child) new Parent(); //자동형변환안됨 앞에 (Parent) 붙여주면 자동형변환되는데 그게 자동캐스팅.
		
		//강제형변환
		//자식인스턴스는 강제형변환 가능OK
		//부모인스턴스는 강제형변환 불가능NG
		//에러:컴파일에러/실행에러(런타임에러)
		Parent p2 = new Parent();
		Child c2 = new Child();
		
		p2 = c2; //자동형변환 일어남
		//형변환전에 인스턴스 유형 체크
		if(p2 instanceof Child) {
			Child c3 = (Child) p2;
		}
		
		System.out.println("end of prog");
		
	}
} //
