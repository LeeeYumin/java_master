package com.yedam.common;

import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

//import com.yedam.student.service.StudentService;
//import com.yedam.student.serviceImpl.StudentServiceMybatis;

public class MainExe { // 만든거 제대로 되는지 테스트. 서버말고 자바에서 실행선택하면됨. 없어도 상관없다.
	public static void main(String[] args) {
////		StudentService svc = new StudentServiceMybatis();
////		String sno = "23-001";
////		//SM.nml => 추가
////		if (svc.remStudent(sno)) {
////			System.out.println("삭제됨"); //삭제됨 문구 뜨고 오라클에서도 삭제됐는지 확인하기
////		} else {
////			System.out.println("삭제실패");
////		}
//
//		SqlSessionFactory factory = DataSource.getInstance();
//		SqlSession session = factory.openSession(true);
//
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		BoardVO vo = new BoardVO();
////		vo.setTitle("aaaa");
////		vo.setContent("123123");
////		vo.setWriter("123123");
////		vo.setBoardNo(4); sql에 들어가는지 확인..?
//
//		// 목록
//		List<BoardVO> list = mapper.selectList(); // 이건 목록보는거. 이거 하고 업데이트구문 해서 주석처리함
//		for (BoardVO bvo : list) {
//			System.out.println(vo.toString()); // run as 자바로 실행
//		}
//
//		// 단건조회
//		vo = mapper.selectOne(2);
//		System.out.println(vo.toString());
//
//		// 추가
//		vo.setTitle("피곤하다");
//		vo.setWriter("id1357");
//		vo.setContent("제곧내");
//		if (mapper.insertBoard(vo) > 0) {
//			System.out.println("글이 추가되었습니다");
//		} else {
//			System.out.println("추가되지않았습니다");
//		}
//
//		// 수정
//		// List<BoardVO> list = mapper.insertBoard(); 아닌가보다..
//		vo.setBoardNo(2);
//		vo.setContent("진짜진짜피곤해");
//		if (mapper.updateBoard(vo) == 1) {
//			System.out.println("수정됨");
//		} else {
//			System.out.println("수정안됨");
//		}
//
//		// 삭제
//		if (mapper.deleteBoard(3) == 1) {
//			System.out.println("삭제됨");
//		} else {
//			System.out.println("삭제안됨");
//		}
//
//		// 조회수 증가
//		if (mapper.updateCnt(2) == 1) {
//			System.out.println("조회수 증가됨");
//		} else {
//			System.out.println("조회수 증가 안됨");
//		}
		
		
		//12.26 Member test
		MemberService svc = new MemberServiceImpl();
		MemberVO vo = svc.login("user1", "1111");
		
		if(vo != null) {
			System.out.println(vo);
			System.out.println("환영!" + vo.getName() + "님. 권한은 " + vo.getResponsibility());
		} else {
			System.out.println("id, pw 확인.");
		}

	} // end of main

}// end of class
