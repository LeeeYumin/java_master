package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;

//import com.yedam.student.service.StudentService;
//import com.yedam.student.serviceImpl.StudentServiceMybatis;

public class MainExe { // 만든거 제대로 되는지 테스트. 서버말고 자바에서 실행선택하면됨
	public static void main(String[] args) {
//		StudentService svc = new StudentServiceMybatis();
//		String sno = "23-001";
//		//SM.nml => 추가
//		if (svc.remStudent(sno)) {
//			System.out.println("삭제됨"); //삭제됨 문구 뜨고 오라클에서도 삭제됐는지 확인하기
//		} else {
//			System.out.println("삭제실패");
//		}

		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		BoardVO vo = new BoardVO();
		vo.setTitle("aaaa");
		vo.setContent("123123");
		vo.setWriter("123123");
		vo.setBoardNo(4);

		//목록
//		List<BoardVO> list = mapper.selectList(); 이건 목록보는거. 이거 하고 업데이트구문 해서 주석처리함
//		for(BoardVO vo : list){
//			System.out.println(vo.toString()); //run as 자바로 실행
		
		//단건조회, 추가, 수정, 삭제

		List<BoardVO> list = mapper.insertBoard();
		
		if (mapper.updateBoard(vo) == 1) {
			System.out.println("작성됨");
		} else {
			System.out.println("작성안됨");
		}
		
		
		
		
		//조회수 증가
//		if(mapper.updateCnt(2) == 1) {
//			System.out.println("조회수 증가됨");
//		} else {
//			System.out.println("조회수 증가 안됨");
//		}
		
		
		
		
	} //end of main

}// end of class
