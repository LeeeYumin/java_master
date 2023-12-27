package com.yedam.student.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudentListCont implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// tiles.xml -> WILDCARD:student/* ->student/{1}.jsp 열겠다는 말
			req.getRequestDispatcher("student/studentList.tiles").forward(req, resp);
		} catch (ServletException e) {
		} catch (Exception e) {
		}
	}
}
