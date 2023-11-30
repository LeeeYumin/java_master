package Todo.p20231129;

public class MemberService {

//	boolean login = true;
//	
//	private String id;
//	private String password;
	
	boolean login(String id, String password) {
		if(id.equals("hong") && password.equals("12345")) { //로그인 매개값 id가 홍이고 매개값 비밀번호 12345일 경우 true 리턴
			return true;
		} else {
			return false; //그 외의 값은 false
		}
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	} //로그아웃 메소드의 내용 출력
	
} //end of class
