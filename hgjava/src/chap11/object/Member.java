package chap11.object;

public class Member {
	private String name;
	private int age;
	
	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//equals
	//@Override사용가능
	public boolean equals (Object obj) {
		//논리적으로 동등한 객체(이름, 나이)
		if(obj instanceof Member) {
			Member target = (Member) obj;
			if(this.name.equals(target.name) && this.age == target.age) { //이름만 비교하려면 && this.age~ 주석처리
				return true;
			}
		}
		return false;	
		
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode(); //중복된값은 제외되고 콘솔창에 3개만 보임
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
} //end of class
