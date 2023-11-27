package chap5;

//복합적인 형태의 데이터 구조.
class Friend {
	String name; //필드
	int age; //필드
	double height; //필드
}

public class ReferenceExe1 {
	public static void main(String[] args) {
		
		//참조변수 : 실제값을 담는것이 아님. 실제 값의 주소를 담고 있음.
		Friend myFriend = new Friend(); //new 라는 키워드로 객체 생성.
		myFriend.name = "김철수";
		myFriend.age = 20;
		myFriend.height = 178.3; //각 위치에 값을 담을 수 있음
		
//		Friend ourFriend = myFriend;
//		
//		myFriend.name = "홍길동";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height); //참조를 하다보니 같이 바뀌는 것처럼 보여짐...?
		
		Friend yourFriend = new Friend(); //new 라는 키워드로 객체 생성.
		yourFriend.name = "김철수";
		yourFriend.age = 20;
		yourFriend.height = 178.3; 
		
		System.out.println(myFriend == yourFriend); //주소값을 비교하기때문에 결과는 항상 false. 속성으로 비교해야 함...
		
		yourFriend = null;
		System.out.println(myFriend.name);
		try {
		System.out.println(yourFriend.name);
		} catch(Exception e) { //try catch 예외처리 (나중에배움)
			System.out.println("null값을 참조합니다.");
		}
		
	//기본 타입. 
	int a = 10;
//	int b =a;
	
	a = 20;
	
	//참조타입 : 그 값을 담고 있는 주소값을 가짐(주소값을 변수에 저장)
	String name = "신용권"; //name 이 변수. 신용권이 객체. // new String("신용권") // 신용권이 가지고 있는 객체의 값은 23dbdae34334
//	String hobby = "독서";
	
	String name1 = "신용권"; //new String("신용권");
	System.out.println("name: " + name);
	System.out.println("name1: " + name1);
	
	
	System.out.println(name == name1); //비교연산자 equals()메소드 활용. ex. name.equals(name1)
	
	
	
	} //
} //
