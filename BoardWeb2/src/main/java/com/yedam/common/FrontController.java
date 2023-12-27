package com.yedam.common;
//컨트롤러 : url을 서블릿 실행. 이건 알고 있어야된다... 20231222...

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.command.AddBoardControl;
import com.yedam.board.command.BoardFormControl;
import com.yedam.board.command.GetBoardControl;
import com.yedam.board.command.ModifyBoardControl;
import com.yedam.board.command.ModifyFormControl;
import com.yedam.board.command.RemoveBoardControl;
import com.yedam.board.command.RemoveFormControl;
import com.yedam.common.command.BoardListControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;
import com.yedam.student.command.StudInfoCont;
import com.yedam.student.command.StudentListCont;

//@WebServlet("*.do") BoardWeb2 자체에서 Run as하면 생성자호출-init service. 그 다음 엔터 다시 하면 service만 호출.
//저장해야 컴파일되고 적용됨!!! 꼭 저장하기.....
//12.27 http://localhost/BoardWeb2/myapp.homepage.tiles
public class FrontController extends HttpServlet {
	// 생명주기 : 생성자 -> init() -> service() -> destroy()

	Map<String, Control> map;

	public FrontController() {
		System.out.println("생성자 호출");
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출."); //url패턴이랑 실행할 controller 서블릿 등록
//		map.put("/main.do", new MainControl());
//		map.put("/sub.do", new SubControl()); //기능은 없고 만들어보는거. 12.26일 수업때 주석처리함
		
		//게시판관련 여기 있는 주소 url 에 치고 접속
		map.put("/boardList.do", new BoardListControl()); //<String, Control> 이 순서로 넣음. vscode 작업 후 /boardList.do 넣음. /목록조회
		map.put("/boardForm.do", new BoardFormControl()); //addBoard.do?title=테스트&content=입력내용&writer=홍길동     /등록
		map.put("/addBoard.do", new AddBoardControl());//추가하고 다시 목록
		map.put("/getBoard.do", new GetBoardControl());//상세조회
		map.put("/modifyForm.do", new ModifyFormControl());//수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl());//수정처리되고 다시 목록으로
		map.put("/removeForm.do", new RemoveFormControl()); //modifyBoard->removeForm으로 수정함. ModifyBoardControl->RemoveFormControl 수정함. /삭제화면
		map.put("/removeBoard.do", new RemoveBoardControl()); //삭제 /삭제처리하는거
		
		//회원관련
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		
		//tiles.관련
		map.put("/studentList.do", new StudentListCont()); //학생목록
		map.put("/studentInfo.do", new StudInfoCont()); //학생단건조회 url 뒤에 ?sno=23-001
	}
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출.");
		String url = req.getRequestURI(); // /BoardWeb2/main.do 를 읽어오는걸 url 이라는 변수에 담는다
		String context = req.getContextPath(); // /BoardWeb2의 값을 가지고 와서
		String path = url.substring(context.length()); // main이 키값.
		System.out.println(path);
		// 어떤 url이 따라오느냐에 따라 처리하는게 다른..? 이건 이해해야 되는 부분임...
		Control ctrl = map.get(path); //ctrl 값 반환해서
		ctrl.execute(req, resp); //execute 메소드 실행
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출.");
	}
}
