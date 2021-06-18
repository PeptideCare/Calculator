package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.memberDAO;
import DTO.memberDTO;

/**
 * Servlet implementation class StudentInfo
 */
@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		memberDAO dao = new memberDAO();
		HttpSession session = request.getSession();
		
		int id = (int)session.getAttribute("memberId");
		int mId = 0;
		
		ArrayList<memberDTO> list = dao.select(id);
		
		for (int i = 0; i < list.size(); i++) {
			memberDTO dto = list.get(i);
			String department = dto.getDepartment();
			String major = dto.getMajor();
			
			mId = (int)session.getAttribute("schoolYear");
			
			int schoolYear = dto.getSchoolYear();
		
			request.setAttribute("id", mId);
			request.setAttribute("department", department);
			request.setAttribute("major", major);
			request.setAttribute("schoolYear", schoolYear);
			
			RequestDispatcher rd = request.getRequestDispatcher("stu_info.jsp");
			rd.forward(request, response);
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
