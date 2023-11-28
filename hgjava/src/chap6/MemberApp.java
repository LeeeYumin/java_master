package chap6;

public class MemberApp {
	
	public static void main(String[] args) {
	//여기부터 프로그램 시작. Member.java 같이보기	
		Member[] members = new Member[10];
		
		members[0] = new Member(1,"Hong", "010-1111" , "Men"); //이게 인스턴스. 인덱스니까 0부터 시작함
		members[1] = new Member(2,"Park", "010-2222" , "Women"); 
		members[2] = new Member(3,"Choi", "010-3333" , "Women"); 
		
		for(int i=0; i<members.length; i++) {
			//if(members[i] != null  && members[i].memberName.equals("Choi")) //null값이 아닐때만, 최씨일때만
				//&& members[i].gender.equals("Women") 으로 응용 가능
				//&& members[i].getGender().equals("Women") 도 응용 가능. getter
				System.out.println(members[i].showAllInfo()); //실행해달라				
				//members[i].showInfo(); 도 가능
		}
		
	} //end of main
	
	static void test1() {
		//이거 public static void main(String[]..) 에 먼저 만들었다가 내림.
		Member mem1 = new Member(); //인스턴스 생성. ()의 의미는 실행하겠단 의미. 호출해야 사용 가능. 
		//mem1은 변수. 주소값을 가지고 있음. 참조형 변수임. 생성자호출이 Member();
		mem1.setMemberNo(10);
//		mem1.memberNo = 10;
		mem1.setMemberName("Hong");
//		mem1.memberName = "Hong";
		mem1.setPhone("010-1234-5667");
//		mem1.phone = "010-1234-5667";
		mem1.setGender("Men");
//		mem1.gender = "Men";
			
		mem1.showInfo();
			
		Member mem2 = new Member(11, "Hwang");
//		mem2.phone = "010-3333-4444";
		mem2.setPhone("010-3333-4444");
		mem2.showInfo();
		
		Member mem3 = new Member(12,"Park", "010-5555-4321","Women");
		mem3.showInfo(); //반환유형 : void
		String msg = mem3.showAllInfo(); //반환유형 : String값으로.
		System.out.println(msg);
	}//end of test1
}//
