package com.yedam.board.command;
//20231226수업. 데이터 가져와서 값 보냄. 페이지 재지정은 url.

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class BoardListControl implements Control {

	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		// 게시글 목록을 boardList.jsp 로 전달
		BoardService svc = new BoardServiceMybatis();
		List<BoardVO> list = svc.boardList();
		req.setAttribute("boardList", list);

		// 페이지 이동. 사용자가 url 입력하면 "board/boardList.jsp" 페이지로 이동
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/boardList.jsp");
		try {
			rd.forward(req, resp); // 요청을 재지정하겠다
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

} //end
