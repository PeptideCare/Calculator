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

@WebServlet("/insertSubject")
public class insertSubject extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int code = Integer.valueOf(request.getParameter("code"));  // 과목코드
		String name = request.getParameter("name");  // 과목명
		String proName = request.getParameter("professorName");  // 교수명
		int year = Integer.valueOf(request.getParameter("year")); // 권장학년
		String classification = request.getParameter("classification"); // 이수구분
		String nameBefore = request.getParameter("nameBefore");  // 18학번 이전 과목명
		int credit = Integer.valueOf(request.getParameter("credit")); // 학점
		int hour = Integer.valueOf(request.getParameter("hour"));  // 시간수
		String className = request.getParameter("className");  // 학과명
		String classBefore = request.getParameter("before18");  // 18학번 이전 이수구분
		
		subjectDAO dao = new subjectDAO();
		ArrayList<subjectDTO> list = dao.select(code);
		
		int subjectCode = 0;
		
		for (int i = 0; i < list.size(); i++) {
			subjectDTO dto = list.get(i);
			subjectCode = dto.getCode();
		}
		
		// 코드가 일치할 시
		if (code == subjectCode){
			out.println("<script>");
			out.println("alert('이미 존재하는 과목코드입니다.');");
			out.println("location.href='EC.jsp'");
			out.println("</script>");
		}
		else {

			dao.insert(code, name, proName, year, classification, nameBefore, credit, hour, className, classBefore);

			out.println("<script>");
			out.println("alert('과목이 등록되었습니다..');");
			out.println("location.href='EC.jsp'");
			out.println("</script>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
