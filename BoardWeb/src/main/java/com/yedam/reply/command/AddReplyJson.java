package com.yedam.reply.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.ReplyVO;

public class AddReplyJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		// insert....
		resp.setContentType("text/json;charset=utf-8");

		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");

		ReplyVO vo = new ReplyVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setReply(reply);
		vo.setReplyer(replyer);

		ReplyService svc = new ReplyServiceImpl();

		Gson gson = new GsonBuilder().create(); //gson lib 활용. 자바객체를 문자열로 쓸수있게..

		Map<String, Object> map = new HashMap<>();

		String json = null;
		try {
			if (svc.addReply(vo)) {
				vo = svc.getReply(vo.getReplyNo()); //단건조회-댓글등록시 이름뜨게

				map.put("retCode", "OK");
				map.put("vo", vo); //실제값을 넘겨야함
				json = gson.toJson(map); //map타입 객체를 Json 문자열로 바꿔줌

				resp.getWriter().print(json);
			} else {
				map.put("retCode", "NG");
				json = gson.toJson(map);

				resp.getWriter().print(json);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
