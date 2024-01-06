package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.serviceImpl.StudentServiceMybatis;
import com.yedam.student.vo.Student;

@WebServlet("/studentList")
public class StudentListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentListServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 목록 페이지.
		StudentService dao = new StudentServiceMybatis();
		//~DAO 에서 인터페이스 작업 후 ~Service로 변경. StudentServiceImpl에서 Mybatis로 또 변경
		List<Student> list = dao.studentList(); //.get에서 studentList로 변경
		

		// out.print("<table border='1'>");
		String str = "<table border='1'>";
		str += "<thead><tr><th>학생번호</th><th>학생이름</th><th>영어점수</th><th>수학점수</th></tr></thead>";
		str += "<tbody>";
		for (Student std : list) {
			str += "<tr><td><a href='getStudentServlet?sno=" //
					+ std.getStudentNumber() + "'>" + std.getStudentNumber()//
					+ "</a></td><td>" + std.getStudentName() //
					+ "</td><td>" + std.getEnglishScore() + "</td><td>" //
					+ std.getMathmaticScore()//
					+ "</td></tr>";
		}
		//<a href='getStudentServlet?sno=23-001'> 이게 이동할 페이지. 
		//학생번호 누르면 이동할 수 있게 23-001 지우고 get 넣어줌
		str += "</tbody></table>";
		str += "<br><a href='student/inform.html'>등록화면</a>"; //서블릿의 기능을 보았다...

		out.print(str);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
