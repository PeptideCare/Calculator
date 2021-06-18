package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.memberDAO;
import DTO.memberDTO;

/**
 * Servlet implementation class Join
 */
@WebServlet("/Join")
public class Join extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int id = Integer.valueOf(request.getParameter("id"));
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String major = request.getParameter("major");
		int schoolYear = Integer.valueOf(request.getParameter("schoolYear"));

		int mId = 0;
		String mPw = "";
		memberDAO dao = new memberDAO();
		
		ArrayList<memberDTO> list = dao.select(id);
		
		for (int i = 0; i < list.size(); i++) {
			memberDTO dto = list.get(i);
			mId = dto.getId();
			mPw = dto.getPassword();
		}
		
		// �й��� �ƴ� ��
		if ((id > 20500000) || ((id) < 20000000)){
			out.println("<script>");
			out.println("alert('�й��� ��Ȯ�ϰ� �Է����ּ���.');");
			out.println("location.href='join.jsp'");
			out.println("</script>");
		
		// �̹� ���� ���� ��
		} else if (id == mId) {
			out.println("<script>");
			out.println("alert('�̹� �����Ͻ� ȸ���Դϴ�.');");
			out.println("location.href='login.jsp'");
			out.println("</script>");
			// �������� ȸ������
		} else {

			dao.insert(id, pw, name, department, major, schoolYear);

			out.println("<script>");
			out.println("alert('ȸ�������� �Ǿ����ϴ�.');");
			out.println("location.href='login.jsp'");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
