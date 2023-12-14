package remind6;

//클래스있는지 확인, 드라이버매니저로 커넥션개체있는지 확인하고 prepare~~
//20231214작업

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainExe {
	static Connection conn;
	
	public static void main(String[] args) {
		//jdbc lib
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결 성공"); //데이터베이스 연결
			//select();
			String sql = "insert into student(stu_no, stu_name, eng, math)\r\n" //\r\n 은 엔터키. 오라클구문 복붙해옴
					+ "values (?, ?, ?, ?)"; //가져온 값에서 입력할수있개 ?로 수정
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "23-003"); //첫번째값에 이거넣겠다
			psmt.setString(2, "박씨"); //두번째값에 이거넣겠다
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);
			
			//***입력, 수정, 삭제 => executeUpdate. executeQuery()는 조회. 2가지는 기억할것***
			int r = psmt.executeUpdate(); //처리된 건수 반환
			if(r==1) {
				System.out.println("입력 성공"); //여기까지하고 오라클하면 3에 박씨 데이터 들어감.
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Driver 없음.");
		}		
	} // end of main
	
	public static void select() throws Exception { //위에 메인 안에 넣어놨다가 나중에 뺐음. 제일 먼저 한 작업임.
		String sql = "select * from student"; //전체컬럼 다 가져오겠다는 의미
		PreparedStatement psmt = conn.prepareStatement(sql); //커넥션 개체가 반환해주는 메소드
		ResultSet rs = psmt.executeQuery();//조회. set 컬렉션이랑 비슷함. 반복문 쓰면됨. add throw~로 오류처리하기
		while(rs.next()) { //가져올값있으면 t 없으면 f
			System.out.println("번호:"+rs.getString("stu_no")+",이름:"+rs.getString("stu_name")//
			+",영어:"+rs.getInt("eng")+",수학:"+rs.getInt("math")); //오라클에 쓴 컬럼이름 넣음
		}
	}
} // end of class
