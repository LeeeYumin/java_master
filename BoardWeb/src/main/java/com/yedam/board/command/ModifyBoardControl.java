package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class ModifyBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");
		String content = req.getParameter("content");
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setContent(content);

		BoardService svc = new BoardServiceMybatis();
		try {
			if (svc.modBoard(vo)) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("boardForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
