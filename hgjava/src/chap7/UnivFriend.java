package chap7;

//자식 : UnivFriend -> Friend(부모)
public class UnivFriend extends Friend {
	//필드
	private String univ; //학과
	private String major; //전공
		
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone); //super는 부모
		this.univ = univ; //this는 나 자신
		this.major = major;
	}
	
	//기본생성자	
	public UnivFriend() {
		// TODO Auto-generated constructor stub
	}

	//메소드. 재정의는 ctrl space 하고 showinfo선택
	
	public String showInfo() {
		return "이름은 " + getName() + "연락처는 " + getPhone() + " 학교는 " + univ + " 전공은 " + major; //부모가 가지고 있는 name 이지만 자식의 것이기도 함
	}
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

} //end of class
