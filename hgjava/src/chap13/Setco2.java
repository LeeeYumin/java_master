package chap13;

public class Setco2 {
	
	public String name;
	public int age;
	
	public Setco2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Setco2 member = (Setco2) obj;
		return member.name.equals(name) && (member.age == age);
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
}
