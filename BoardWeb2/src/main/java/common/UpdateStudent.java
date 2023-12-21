package common;
//만들어는 봄 근데 맞게 만들었는지도 모르겠다
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStudent extends HttpServlet{

	public UpdateStudent() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String sno = request.getParameter("sno");
		
		StudentDAO dao = new StudentDAO();
		Student std = dao.getStudent(sno);
		
		
		response.setContentType("text/html;charset=utf-8");
}
	
	
	
	
	
}
