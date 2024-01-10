package com.yedam.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.mapper.MemberMapper;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	//인터페이스를 구현하는 클래스임
	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);

	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> memberList() {
		return mapper.selectList();
	}

	@Override
	public boolean addMember(MemberVO vo) {
		return mapper.insertMember(vo) == 1;
	}

	@Override
	public boolean removeMember(String id) {
		return mapper.deleteMember(id) == 1;
	}

}
