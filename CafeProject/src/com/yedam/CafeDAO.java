package com.yedam;

import java.sql.*;
import java.util.ArrayList;

public class CafeDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	ArrayList<Member> members;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 주문하기
	boolean step1(int user, String name) {
		getConn();
		String sql = "insert into product (c_user,c_name) values(?,?)";
		ArrayList<Member> member = new ArrayList<Member>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			psmt.setInt(1, user);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	// 주문내역(단건)
//	Member step2(int user) { 
//		getConn();
//		String sql = "select * from users where c_user=?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, user );
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				Member member = new Member();
//				member.setCuser(rs.getInt("c_user"));
//				member.setCname(rs.getString("c_name"));
//				member.setPname(rs.getString("p_name"));
//				member.setDname(rs.getString("d-name"));
//				member.setTake(rs.getInt("take"));
//				return member;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	// 주문목록
	Member[] getMemberList() {
		getConn();
		Member[] members = new Member[50];
		String sql = "select * from users";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setCuser(rs.getInt("c_user"));
				member.setCname(rs.getString("c_name"));
				member.setPname(rs.getString("p_name"));
				member.setDname(rs.getString("d_name"));
				member.setTake(rs.getInt("take"));
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member;
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;

	}

// 주문취소

// 주문수정

// 종료

} // end of class
