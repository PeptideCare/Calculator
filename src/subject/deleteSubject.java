package subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.subjectDAO;
import DTO.subjectDTO;

/**
 * Servlet implementation class deleteSubject
 */
@WebServlet("/deleteSubject")
public class deleteSubject extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int code = Integer.valueOf(request.getParameter("code"));  // 과목코드
		String name = request.getParameter("name");  // 과목명
		
		subjectDAO dao = new subjectDAO();
		ArrayList<subjectDTO> list = dao.select(code);
		
		int subjectCode = 0;
		String subjectName = "";
		
		for (int i = 0; i < list.size(); i++) {
			subjectDTO dto = list.get(i);
			subjectCode = dto.getCode();
			subjectName = dto.getName();
		}
		
		// 존재하지 않는 과목일 시
		if (code != subjectCode || !name.equals(subjectName)){
			out.println("<script>");
			out.println("alert('과목정보가 일치하지 않습니다');");
			out.println("location.href='CD.jsp'");
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('과목이 삭제되었습니다');");
			out.println("location.href='CD.jsp'");
			out.println("</script>");
			
			dao.delete(code, name);
			response.sendRedirect("CD.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
