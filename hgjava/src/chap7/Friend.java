package chap7;

//import 했다가 lombok 지움 
//부모 : 이름, 연락처, showInfo()

public class Friend {
	
	//필드
	private String name;
	private String phone;
	
	//기본생성자	
	public Friend() {
		super();
	}

	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	//메소드
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	public String showInfo() {
		return "이름은 " + name + "연락처는 " + phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
} //end of class
