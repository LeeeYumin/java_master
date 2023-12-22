package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.serviceImpl.StudentServiceMybatis;
import com.yedam.student.vo.Student;

/**
 * Servlet implementation class StudentListServ
 */
@WebServlet("/studentList") // 이건 밑의 StudentListServ 를 실행하기 위한 url
public class StudentListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentListServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("Text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();

		// 목록 페이지
		StudentService dao = new StudentServiceMybatis(); //~DAO 에서 인터페이스 작업 후 ~Service로 변경. StudentServiceImpl에서 Mybatis로 또 변경
		List<Student> list = dao.studentList(); //.get에서 studentList로 변경

		// out.print("<table border = '1'>");
		String str = "<table border = '1'>";
		str += "<thead><tr><th>학생번호</th><th>학생이름</th><th>영어점수</th><th>수학점수</th></tr></thead>";
		str += "<tbody>";
		for (Student std : list) {
			str += "<tr><td><a href='getStudentServlet?sno="+std.getStuNo()+"'>"+std.getStuNo()+"</a></td><td>"+std.getStuName()+"</td><td>"+std.getEng()+"</td><td>"+std.getMath()+"</td></tr>";
		} //<a href='getStudentServlet?sno=23-001'> 이게 이동할 페이지. 학생번호 누르면 이동할 수 있게 23-001 지우고 get 넣어줌
		str += "</tbody></table>";
		str += "<br><a href='student/inform.html'>등록화면</a>";
		//서블릿의 기능을 보았다...
		
		out.print(str);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
