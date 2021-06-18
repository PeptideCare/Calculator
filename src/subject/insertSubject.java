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
		
		int code = Integer.valueOf(request.getParameter("code"));  // �����ڵ�
		String name = request.getParameter("name");  // �����
		String proName = request.getParameter("professorName");  // ������
		int year = Integer.valueOf(request.getParameter("year")); // �����г�
		String classification = request.getParameter("classification"); // �̼�����
		String nameBefore = request.getParameter("nameBefore");  // 18�й� ���� �����
		int credit = Integer.valueOf(request.getParameter("credit")); // ����
		int hour = Integer.valueOf(request.getParameter("hour"));  // �ð���
		String className = request.getParameter("className");  // �а���
		String classBefore = request.getParameter("before18");  // 18�й� ���� �̼�����
		
		subjectDAO dao = new subjectDAO();
		ArrayList<subjectDTO> list = dao.select(code);
		
		int subjectCode = 0;
		
		for (int i = 0; i < list.size(); i++) {
			subjectDTO dto = list.get(i);
			subjectCode = dto.getCode();
		}
		
		// �ڵ尡 ��ġ�� ��
		if (code == subjectCode){
			out.println("<script>");
			out.println("alert('�̹� �����ϴ� �����ڵ��Դϴ�.');");
			out.println("location.href='EC.jsp'");
			out.println("</script>");
		}
		else {

			dao.insert(code, name, proName, year, classification, nameBefore, credit, hour, className, classBefore);

			out.println("<script>");
			out.println("alert('������ ��ϵǾ����ϴ�..');");
			out.println("location.href='EC.jsp'");
			out.println("</script>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
