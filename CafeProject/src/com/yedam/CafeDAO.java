package com.yedam;

//insert update delete 빼고는 select

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
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // @192.168.0.23:1521:
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

	// 목록(1~4)
	ArrayList<Product> orderview() {
		getConn();
		ArrayList<Product> products = new ArrayList<Product>();
		String sql = "select p_number, p_name, p_price from product";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) { // 몇개 가져올지 모르니까 while 문으로 looping
				Product product = new Product();
				product.setPnumber(rs.getInt("p_number"));
				product.setPname(rs.getString("p_name"));
				product.setPprice(rs.getInt("p_price"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return products;
	}

	// 목록(5~8)
	ArrayList<Dessert> orderview2() {
		getConn();
		ArrayList<Dessert> products = new ArrayList<Dessert>();
		String sql = "select d_number, d_name, d_price  from dessert";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Dessert product = new Dessert();
				product.setDnumber(rs.getInt("d_number"));
				product.setDname(rs.getString("d_name"));
				product.setDprice(rs.getInt("d_price"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return products;
	}

	// 주문
	boolean order(int pnumber, int dnumber, int cuser, String take) {
		getConn();
		String sql = " insert into receipt values (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cuser);
			psmt.setInt(2, pnumber);
			psmt.setInt(3, dnumber);
			psmt.setString(4, take);

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 주문목록조회
	ArrayList<Receipt> receipt(int cuser) {
		getConn();
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		String sql = "select u.c_name, p.p_name, d.d_name , decode(r.take,1,'매장','포장') take\r\n"
				+ "from receipt r, product p, dessert d, users u\r\n"//
				+ "where r.p_name = p.p_number\r\n"//
				+ "and r.d_name = d.d_number\r\n"//
				+ "and r.c_user = u.c_user "//
				+ "and r.c_user = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, cuser);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Receipt receipt = new Receipt();
				receipt.setCname(rs.getString("c_name"));
				receipt.setPname(rs.getString("p_name"));
				receipt.setDname(rs.getString("d_name"));
				receipt.setTake(rs.getString("take"));

				receipts.add(receipt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return receipts;
	}

// 주문취소	
	boolean removeOrder(int cuser) {
		getConn();
		String sql = "delete from receipt where c_user=? ";
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
	boolean modifyOrder(String pname, String dname, String take, int cuser) {
		getConn();
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		String sql = "update receipt set p_name = ?, d_name = ?, take = ? where c_user = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pname);
			psmt.setString(2, dname);
			psmt.setString(3, take);
			psmt.setInt(4, cuser);
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
