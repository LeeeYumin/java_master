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
		// 글번호 조회. GetBoardControl 복사하고 부분 수정
		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));

		req.setAttribute("vo", vo);

		// 페이지 이동(forward)
		RequestDispatcher rd = //사용자가 url 입력하면 board/modBoardForm.jsp로 이동함
				req.getRequestDispatcher("WEB-INF/board/modBoardForm.jsp");
		try {
			rd.forward(req, resp); // 요청을 재지정 하겠음
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
