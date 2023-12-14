package Todo.p20231214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//20231214 5~6교시 실습..

public class BookDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//목록
	ArrayList<Book> getBookList(){
		getConn();
		ArrayList<Book> bary = new ArrayList<>(); //변수는 소문자로. 자기자신 선언불가. 타입 같게.
		String sql = "select * from book order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
		}
		
		
	}//getBookList()
	
	
	
	
} //end of class
