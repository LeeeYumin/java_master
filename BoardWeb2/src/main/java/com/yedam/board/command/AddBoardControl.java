package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control { // 이거 만들때는 프론트컨트롤러에서

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter title, content, writer 3개 받고 db에 insert 하고 목록 보여주는 페이지까지.
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		;
		String content = req.getParameter("content");
		;

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		// svc addBoard() 활용.
		BoardService svc = new BoardServiceMybatis();

		try {
			if (svc.addBoard(vo)) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("boardForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}