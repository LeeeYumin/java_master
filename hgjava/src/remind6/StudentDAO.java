package remind6;

//20231214작업

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//저장공간 : Oracle DB.

//추가 수정 삭제 executeQuery / 목록 단건조회. StudentExe 기능을 여기에 넣을거임
public class StudentDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs; // 자주 쓸거니까 위로 뺌.
	
	//연결접속 해제
	void disconn() {
		try {
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
			if(psmt != null)
				psmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			disconn();
		}
		return conn;
	}

	// 목록
	Student[] getStudentList() {
		getConn();
		Student[] students = new Student[10];
		String sql = "select * from student order by 1"; // 학생번호 순 정렬
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student(); // Student.java에 기본생성자없으면 여기서 에러남
				student.setstuNo(rs.getString("stu_no"));
				student.setStuName(rs.getString("stu_name"));
				student.setEng(rs.getInt("eng"));
				student.setMath(rs.getInt("math"));
				// 배열의 빈 위치에 한 건 저장.
				for (int i = 0; i < students.length; i++) {
					if (students[i] == null) {
						students[i] = student;
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconn();
		}
		return students;
	} // end of getStudentList().

//추가
	boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?,?,?,?)"; // 순서지키기
		try {
			//conn.setAutoCommit(false); 자동커밋 실행여부
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStuNo());
			psmt.setString(2, std.getStuName());
			psmt.setInt(3, std.getEng());
			psmt.setInt(4, std.getMath());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r == 1) {
				//conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconn();
		}
		return false;
	} // end of addStudent

	// 단건 조회
	Student getStudent(String sno) {
		getConn();
		String sql = "select * from student where stu_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Student student = new Student();
				student.setstuNo(rs.getString("stu_no"));
				student.setStuName(rs.getString("stu_name"));
				student.setEng(rs.getInt("eng"));
				student.setMath(rs.getInt("math"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회된 값이 없으면 null 값 반환
	}// end of getStudent

	// 수정
	boolean modifyStudent(int eng, int math, String stuNo) {
		getConn(); // 윗줄3개 들어간다는 말
		String sql = "update student " + "set eng = ?, " + "math = ? " + "where stu_no = ? "; // 오라클에서 가져옴
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, math);
			psmt.setString(3, stuNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconn();
		}
		return false;
	}// modifyStudent

	// 여러건 삭제 (동일한 값 한번에 삭제하기. 김민수 3건 있던거 없어짐 확인함)
	boolean removeStudent(String stuName) {
		getConn();
		String sql = "delete from student where stu_name=? ";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stuName);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			disconn();
		}
		return false;
	}

}// end of class
