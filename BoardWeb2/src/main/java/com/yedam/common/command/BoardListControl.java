package com.yedam.common.command;

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
		// 데이터를 조회해서 게시글목록을 boardList.jsp로 전달하는 역할. 
		BoardService svc = new BoardServiceMybatis();
		List<BoardVO> list = svc.boardList(); //list는 참조값. boardList.jsp에 값을 알려줘야 함.
		
		req.setAttribute("boardList", list);
		
		//페이지 이동(forward)
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/boardList.jsp"); //요청하는데 boardListg로 재지정 요청..
		try {
			rd.forward(req, resp); //req에 참조값 list를 보내서 resp...
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
