package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class ModifyBoardControl implements Control { // 수정되는 기능 넣는 부분

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		// bno랑 content 수정. 2개 파라미터 받아옴.
		String bno = req.getParameter("bno");
		String content = req.getParameter("content");

		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setContent(content);
		// svc addBoard() 활용.
		BoardService svc = new BoardServiceMybatis();

		if (svc.modBoard(vo)) {
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try {
				resp.sendRedirect("modifyForm.do");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}