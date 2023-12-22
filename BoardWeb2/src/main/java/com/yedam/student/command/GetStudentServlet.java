package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

@WebServlet("/getStudentServlet")
public class GetStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//url?sno=23-010&sname=홍길동 파라메터 넣어줘야함
		resp.setContentType("Text/html;charset=utf-8");
		String sno = req.getParameter("sno");
		
		StudentService dao = new StudentServiceImpl(); //~DAO 에서 인터페이스 작업 후 ~Service로 변경
		Student std = dao.getStudent(sno);
		
		String str = "<table border='1'>";
		str += "<caption>학생정보</caption>";
		str += "<tr><th>학번</th><td>"+std.getStuNo()+"</td>";
		str += "<tr><th>이름</th><td>"+std.getStuName()+"</td>";
		str += "<tr><th>영어</th><td>"+std.getEng()+"</td>";
		str += "<tr><th>수학</th><td>"+std.getMath()+"</td>";
		str += "</table>";
		//상세화면
		str += "<br><a href='modifyStudent?sno="+std.getStuNo()+"'>수정화면</a>"; //공란도 값이라서 없게 할것
		str += "<br><a href='studentList'>목록</a>";
		
		//사용자 페이지로 출력
		resp.getWriter().print(str);
		
	}
}
