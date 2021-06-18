package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.memberDAO;
import DTO.memberDTO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int id = Integer.valueOf(request.getParameter("id"));
		String password = request.getParameter("pw");

		memberDAO dao = new memberDAO();

		ArrayList<memberDTO> list = dao.select(id);

		// ���̵� ���� ��
		if (list.isEmpty()) {
			out.println("<script>");
			out.println("alert('ȸ�������� ���ּ���.');");
			out.println("location.href='join.jsp'");
			out.println("</script>");

			// ���̵� ���� ��
		} else {
			for (int i = 0; i < list.size(); i++) {
				memberDTO dto = list.get(i);
				int mId = dto.getId();
				String mPw = dto.getPassword();
				String num = String.valueOf(mId);
				int schoolYear = Integer.valueOf(num.substring(2, 4));

				// �������� �α���
				if ((mId==id) && mPw.equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("memberId", mId);
					session.setAttribute("schoolYear", schoolYear);
					
					out.println("<script>");
					out.println("alert('�α����� �Ǿ����ϴ�.');");
					out.println("</script>");

					response.sendRedirect("menu.jsp");
					// ���̵�� �ִµ� ��й�ȣ�� ���� ��
				} else {
					out.println("<script>");
					out.println("alert('��й�ȣ�� �ùٸ��� �ʽ��ϴ�.');");
					out.println("location.href='login.jsp'");
					out.println("</script>");
				}
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
