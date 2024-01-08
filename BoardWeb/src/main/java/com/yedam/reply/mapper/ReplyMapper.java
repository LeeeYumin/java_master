package com.yedam.reply.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(int boardNo); //목록 가져오기
	List<ReplyVO> replyListPaging(@Param("boardNo") int boardNo, @Param("page") int page); //댓글페이징
	int deleteReply(int replyNo); //댓글삭제
	int insertReply(ReplyVO vo); //댓글등록
	ReplyVO selectReply(int replyNo); //단건조회 (댓글등록시 이름등록되게)
	
	//페이지 계산하기 위한 전체건수 반환
	int selectCount(int boardNo);
	//차트데이터(댓글자, 작성건수)
	List<HashMap<String, Object>> selectReplyCnt(); //<HashMap key와 value<칼럼,데이터>>
	
}
