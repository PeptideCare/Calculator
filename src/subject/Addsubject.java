package subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.mySubjectDAO;
import DAO.subjectDAO;
import DTO.mySubjectDTO;
import DTO.subjectDTO;
import DTO.memberDTO;

@WebServlet("/Addsubject")
public class Addsubject extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("memberId");
		
		int code = Integer.valueOf(request.getParameter("code")); 
		String name = request.getParameter("name");  
		String classification = request.getParameter("classification"); 
		int credit = Integer.valueOf(request.getParameter("credit")); 
		
		// 내가 들은 과목
		mySubjectDAO mdao = new mySubjectDAO();
		ArrayList<mySubjectDTO> mlist = mdao.select(userId);
		
		// 과목
		subjectDAO sdao = new subjectDAO();
		ArrayList<subjectDTO> slist = sdao.select(code);
		
		int scode = 0;  // 과목테이블 코드
		int subjectCode = 0; // 내가 들은 과목 테이블 코드
		
		for (int j = 0; j < mlist.size(); j++) {
			mySubjectDTO dto = mlist.get(j);
			subjectCode = dto.getSubjectCode();
		}
		
		for (int i = 0; i < slist.size(); i++) {
			subjectDTO sdto = slist.get(i);
			scode = sdto.getCode();
		}
		
		if (scode == 0) {
			out.println("<script>");
			out.println("alert('존재하지 않는 과목입니다.');");
			out.println("location.href='credit_input.jsp'");
			out.println("</script>");
		} 
		else if (code == subjectCode){
			out.println("<script>");
			out.println("alert('이미 존재하는 과목입니다.');");
			out.println("location.href='credit_input.jsp'");
			out.println("</script>");
		}
		else {

			mdao.insert(userId, code, name, classification, credit);

			out.println("<script>");
			out.println("alert('과목이 등록되었습니다..');");
			out.println("location.href='credit_input.jsp'");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
