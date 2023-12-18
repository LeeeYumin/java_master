package com.yedam;

import java.sql.*;
import java.util.ArrayList;

public class CafeDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	ArrayList<Member> members;

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

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("-");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 로그인
	boolean login(int cuser, String cname) {
		getConn();
		String sql = "select c_user, c_name from users where c_user = ? AND c_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cuser);
			psmt.setString(2, cname);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 메뉴목록(1~4/5~8)
	ArrayList<Product> order(int pnumber, int dnumber, String take) {
		getConn();
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select p_number, d_number, take from product where p_number =? AND d_number = ? AND take = ?";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setPnumber(rs.getInt("p_number"));
				product.setDnumber(rs.getInt("d_number"));
				product.setTake(rs.getString("take"));
				for (int i = 0; i < products.size(); i++) {
					if (products != null) {						
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return products;
	}

	// 주문하기

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
				Product prod = new Product();
				member.setCuser(rs.getInt("c_user"));
				member.setCname(rs.getString("c_name"));
				prod.setPnumber(rs.getInt("p_name"));
				prod.setDnumber(rs.getInt("d_number"));
				prod.setTake(rs.getString("take"));
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member;
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return members;
	}

// 주문취소
	boolean removeOrder(int cuser) {
		getConn();
		String sql = "delete from product where c_user=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cuser);
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

// 주문수정
	boolean modifyOrder(int pnumber, int dnumber, int take) {
		getConn();
		String sql = "update product " + "set p_number = ?, " + "d_number = ? " + "where c_user=? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pnumber);
			psmt.setInt(2, dnumber);
			psmt.setInt(3, take);
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
	} // modifyOrder

}// end of class
