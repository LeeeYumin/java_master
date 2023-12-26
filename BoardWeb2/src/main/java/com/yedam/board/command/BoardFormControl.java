package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class BoardFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 등록화면 열어주는 기능
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/addBoardForm.jsp"); // 요청하는데 boardList로 재지정 요청..
		try {
			rd.forward(req, resp); // req에 참조값 list를 보내서 resp...
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
