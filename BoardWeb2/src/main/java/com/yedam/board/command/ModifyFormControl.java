package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class ModifyFormControl implements Control { // 수정되는 화면 보여지는 부분

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 글번호 조회 GetBoardControl 복사하고 28줄만 수정

		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = new BoardVO();

		req.setAttribute("vo", vo);

		// 페이지 이동(forward) 복사
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/modBoardForm.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
