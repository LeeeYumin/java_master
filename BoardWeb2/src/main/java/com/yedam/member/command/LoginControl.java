package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// id, pw 를 불러들여서 정상이라면 글목록으로.
		//					 비졍상은 로그인화면으로.
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		
		MemberVO vo = svc.login(id, pw);
		
		if(vo != null) { //로그인 성공. ->세션에 정보 담아야 됨. 세션객체에 로그인정보를 저장함.
			HttpSession session = req.getSession(); //req.:요청정보
			session.setAttribute("logId", vo.getId()); //세션객체에 로그인아이디값 저장
			session.setAttribute("logName", vo.getName());
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("message", "아이디, 비밀번호 확인하세요");
			try {
			req.getRequestDispatcher("WEB-INF/member/logForm.jsp").forward(req, resp);
		}catch (ServletException | IOException e) {
			e.printStackTrace();

		}
		}
	}
}
//
