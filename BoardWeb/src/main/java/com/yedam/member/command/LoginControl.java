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
		//                              비정상이면 로그인화면으로

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		MemberService svc = new MemberServiceImpl();

		MemberVO vo = svc.login(id, pw);

		if (vo != null) {
			// 로그인 성공. ->세션에 정보 담아야 됨. 세션객체에 로그인정보를 저장함.
			HttpSession session = req.getSession(); //req.:요청정보
			session.setAttribute("logId", vo.getId());// 세션객체에 로그인아이값을 저장.
			session.setAttribute("logName", vo.getName());
			////권한 세션에 지정(관리자 user3 로그인)
			session.setAttribute("responsibility", vo.getResponsibility());
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			req.setAttribute("message", "아이디와 비밀번호를 확인하세요.");
			try {
				req.getRequestDispatcher("WEB-INF/member/logForm.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
