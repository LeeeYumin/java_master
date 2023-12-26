package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.common.Control;

public class RemoveBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		// 파라메타("bno") - 삭제되면 목록으로 넘어가겠다
		int bno = Integer.parseInt(req.getParameter("bno"));

		BoardService svc = new BoardServiceMybatis();

		if (svc.remBoard(bno)) {
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("removeForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

} //
