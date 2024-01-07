package com.yedam.board.command;

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

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 데이터 조회해서 게시글 목록을 boardList.jsp 로 전달하는 역할
		BoardService svc = new BoardServiceMybatis();
		List<BoardVO> list = svc.boardList(); //list는 참조값. boardList.jsp 에 값을 알려줘야 함

		req.setAttribute("boardList", list);

		// 페이지 이동(forward)
		RequestDispatcher rd //
				= req.getRequestDispatcher("board/boardList.tiles"); //요청하는데 boardList로 재지정 요청
		try {
			rd.forward(req, resp); //요청을 재지정함
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}// end
