package com.yedam.reply.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.ReplyVO;

public class ReplyListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// json 데이터를 생성해서 반환.
		// [{"replyNo":4,"boardNo":2,"reply":"test1","replyer":"user1"},{}.....{}]
		resp.setContentType("text/json;charset=utf-8"); //한글 인코딩 되게 맨 위에 써줌
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		page = page == null ? "1" : page; //페이지 값이 없으면 1이라는 값을 넣어주자

		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyListPaging(Integer.parseInt(bno), Integer.parseInt(page)); //요청글번호 파라메터로 씀
		int cnt = list.size();
		String json = "[";
		for (int i = 0; i < cnt; i++) {
			json += "{\"replyNo\":" + list.get(i).getReplyNo() + ",\"boardNo\":" //
					+ list.get(i).getBoardNo() + ",\"reply\":\"" + list.get(i).getReply() //
					+ "\",\"name\":\"" + list.get(i).getName() + "\"}";
			if (i != cnt - 1) {
				json += ",";
			}
		}

		json += "]"; //String은 보여지는 형태..? 때문에 넣음

		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
