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
		
		// ���� ���� ����
		mySubjectDAO mdao = new mySubjectDAO();
		ArrayList<mySubjectDTO> mlist = mdao.select(userId);
		
		// ����
		subjectDAO sdao = new subjectDAO();
		ArrayList<subjectDTO> slist = sdao.select(code);
		
		int scode = 0;  // �������̺� �ڵ�
		int subjectCode = 0; // ���� ���� ���� ���̺� �ڵ�
		
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
			out.println("alert('�������� �ʴ� �����Դϴ�.');");
			out.println("location.href='credit_input.jsp'");
			out.println("</script>");
		} 
		else if (code == subjectCode){
			out.println("<script>");
			out.println("alert('�̹� �����ϴ� �����Դϴ�.');");
			out.println("location.href='credit_input.jsp'");
			out.println("</script>");
		}
		else {

			mdao.insert(userId, code, name, classification, credit);

			out.println("<script>");
			out.println("alert('������ ��ϵǾ����ϴ�..');");
			out.println("location.href='credit_input.jsp'");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
