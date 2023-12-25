package com.yedam.student.command;

//만들어는 봄 근데 맞게 만들었는지도 모르겠다
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {

	public UpdateStudent() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sno = request.getParameter("sno");
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");

		StudentService dao = new StudentServiceImpl(); // ~DAO 에서 인터페이스 작업 후 ~Service로 변경
		boolean done = dao.modStudent(sno, Integer.parseInt(escore), Integer.parseInt(mscore));

		response.setContentType("text/html;charset=utf-8");

		// 수정? 여기가 맞는지는 모르겠음... 21일 오후 끝 실습(못하면 과제로 나가는 거)
		
		PrintWriter out = response.getWriter();
		
		if(done) {
			out.println("<script>alert('OK'); location.href='student/studentList.jsp'; </script>"); 
		}else {
			out.println("<script>alert('Fail'); location.href='index.html'; </script>");
			
		}
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

} //end of class