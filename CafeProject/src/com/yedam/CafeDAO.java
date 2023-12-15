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
			conn = DriverManager.getConnection(url, "dev" , "dev");
			System.out.println("연결됨");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	boolean grade1(int num) {
		getConn();
		String sql = "insert into product (p_number,take) values(?,?)";
		ArrayList<Member> member = new ArrayList<Member>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); 
			psmt.setInt(1, num);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
} //end of class
