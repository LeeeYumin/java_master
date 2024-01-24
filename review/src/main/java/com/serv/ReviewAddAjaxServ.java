package com.serv;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewAddAjaxServ
 */
@WebServlet("/reviewAddAjaxServ")
public class ReviewAddAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String content = request.getParameter("content");
		System.out.println(name + ":" + content);
		response.setContentType("application/json"); //text/plain; charset=UTF-8
		//Map<String, Object>map = new HashMap<>();
		//map.put("result", "success");
		//String str = gson.toJson(map); //vo, list, map ==> json string {, [ 시작
		response.getWriter().append("{\"result\":\"success\"}"); //str
	}
}


