package com.yedam.common;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.PageDTO;

public class MainExe {
	public static void main(String[] args) {
//		ReplyService svc = new ReplyServiceImpl();
//		svc.replyListPaging(3, 4).forEach(reply -> System.out.println(reply));
		
//		int total = 70;
//		PageDTO dto = new PageDTO(13,total);
//		System.out.println(dto.toString());
		
		ReplyService svc = new ReplyServiceImpl();
		List<HashMap<String, Object>> list = svc.chartData();
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(list));
		
	}
}
