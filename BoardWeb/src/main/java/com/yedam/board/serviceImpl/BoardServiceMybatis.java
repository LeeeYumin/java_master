package com.yedam.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.service.BoardService;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.DataSource;

public class BoardServiceMybatis implements BoardService {

	SqlSession session = DataSource.getInstance().openSession(true); //Mybatis 규칙 따라씀
	BoardMapper mapper = session.getMapper(BoardMapper.class); //인터페이스 mapper 가 갖고있는 = 인스턴스

	@Override
	public List<BoardVO> boardList() {
		return mapper.selectList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		mapper.updateCnt(bno);  //클릭수증가
		return mapper.selectOne(bno);
	}

	@Override
	public boolean addBoard(BoardVO vo) {
		return mapper.insertBoard(vo) == 1;
	}

	@Override
	public boolean modBoard(BoardVO vo) {
		return mapper.updateBoard(vo) == 1;
	}

	@Override
	public boolean remBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

}
