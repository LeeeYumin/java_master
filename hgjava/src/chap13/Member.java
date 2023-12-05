package chap13;

import lombok.Data;

@Data

public class Member {
	private String memberNo;
	private String memberName;
	private int point;
	
	
	//hashCode, equals 정의하는 지에 따라 동일객체(23.12.05추가)
	//hashCode, equals 는 논리값이 같으면 같은 값으로 반환.. 똑같아보여도 다른값임...
	//5줄의 @Data 역할이 hashCode랑 equals 랑 만들어주는 기능인데 동일한 객체를 만들어주면 4건이어도 3건만 만들어짐... (MapExe2)
	//@Override
	//public int hashCode() {
		//return super.hashCode();
	//}

	
	// 생성자
	public Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;

	}

	// getter setter
	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	
	


} //end of class
