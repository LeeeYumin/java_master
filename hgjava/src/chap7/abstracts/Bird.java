package chap7.abstracts;

public class Bird extends Animal { //Bird 에러남. Add~method 로 에러 해결해줘야됨

	@Override
	public void sound() {
		// 추상클래스를 상속하는 자식클래스는 추상메소드를 구현해줘야함
		System.out.println("짹짹");
		
	} 

} //end
