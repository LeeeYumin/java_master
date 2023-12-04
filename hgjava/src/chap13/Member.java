package chap13;

import lombok.Data;

@Data

public class Member {
	private String memberNo;
	private String memberName;
	private int point;

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
