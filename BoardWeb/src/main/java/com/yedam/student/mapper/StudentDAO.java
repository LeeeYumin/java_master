package com.yedam.student.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.student.vo.Student;

//저장공간: Oracle DB.

//추가/수정/삭제/목록/단건조회.
public class StudentDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 연결접속 해제.
	void disconn() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 목록.
	public List<Student> getStudentList() {
		getConn();
		List<Student> students = new ArrayList<>();
		String sql = "select * from student order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNumber(rs.getString("student_number"));
				student.setStudentName(rs.getString("student_name"));
				student.setEnglishScore(rs.getInt("english_score"));
				student.setMathmaticScore(rs.getInt("mathmatic_score"));

				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return students;
	} // end of getStudentList().

// 추가.
	public boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?,?,?,?) ";
		try {
			conn.setAutoCommit(false); // 자동커밋 실행 여부.
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, std.getStudentNumber());
			psmt.setString(2, std.getStudentName());
			psmt.setInt(3, std.getEnglishScore());
			psmt.setInt(4, std.getMathmaticScore());

			int r = psmt.executeUpdate();// 처리된 건수 반환.

			if (r == 1) {
				conn.commit();
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	} // end of addStudent()

	// 단건조회.
	public Student getStudent(String sno) {
		getConn();
		String sql = "select * from student where student_number=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				Student student = new Student();
				student.setStudentNumber(rs.getString("student_number"));
				student.setStudentName(rs.getString("student_name"));
				student.setEnglishScore(rs.getInt("english_score"));
				student.setMathmaticScore(rs.getInt("mathmatic_score"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null; // 조회된 값이 없으면 null 값 반환.
	} // end of getStudent

	public boolean modifyStudent(String no, int eng, int mat) {
		getConn();
		String sql = "update student "//
				+ "   set english_score=? "//
				+ "      ,mathmatic_score=? "//
				+ "   where student_number=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, mat);
			psmt.setString(3, no);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	} //

	public boolean removeStudent(String name) {
		getConn();
		String sql = "delete from student where student_name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}
}
