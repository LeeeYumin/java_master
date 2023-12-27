package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	//업무로직. 컬렉션타입으로 반환함. 인터페이스는 메소드 정의하는 부분임
	public List<BoardVO> boardList(); //목록가지고오는거
	public BoardVO getBoard(int bno); //글번호 조회
	public boolean addBoard(BoardVO vo); //글등록
	public boolean modBoard(BoardVO vo); //글수정
	public boolean remBoard(int bno); //글삭제
	
} //
