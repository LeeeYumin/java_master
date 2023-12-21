package common; //http://localhost/BoardWeb/MyInfoServlet

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/MyInfoServlet") //이게 url
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** HttpServlet 이거 상속받아서 쓰면 됨. 밑에 doGet doPost는 메소드.. 매개값 2개씩 받아온다. 이걸 톰캣이 만들어줌
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoServlet() { //자바생성자
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); //이거 넣어주면 한글됨. content 타입:txt/html/json인지..
		
		//파라미터 확인
		//url에서 복붙함. ?sno=23-010&sname=황철수&escore=80&mscore=85 &는 구분자 역할이라 넣으면 안됨
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String escore = request.getParameter("escore"); //getParameter문자열타입이라서 int 말고. 웹은 다 String임!
		String mscore = request.getParameter("mscore");
		
		System.out.println("sno : " + sno + ",sname :" + sname + ",escore" + escore + ",mscore" + mscore);
		
		//db 저장
		Student std = new Student(sno, sname,Integer.parseInt(mscore), Integer.parseInt(escore));
		StudentDAO dao = new StudentDAO();
		boolean done = dao.addStudent(std);
		
		PrintWriter out= response.getWriter(); //이거 쓰고 import
		//out.append("Served at: ").append(request.getContextPath());
		out.println("<h3>Welcome Servlet , 안녕</h3>"); //한글은 안된다. ?로 보임
		out.println("<a href='index.html'>인덱스 이동</a>");
		
		if(done) {
			out.println("<script>alert('OK'); location.href='student/studentList.jsp'; </script>"); //location.href=''; 목록이동
		}else {
			out.println("<script>alert('Fail'); location.href='index.html'; </script>"); //http://localhost/BoardWeb/student/inform.html? 여기서 실행해봄
			//내부서버오류는 라이브러리없어서 나는거. maven... 
		}
	} //주소치고 링크에 의해 열려지는게 doGet. 대부분 이거??


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
