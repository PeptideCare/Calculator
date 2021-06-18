package subject;

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

import DAO.mySubjectDAO;
import DTO.mySubjectDTO;
import DTO.memberDTO;

/**
 * Servlet implementation class Join
 */
@WebServlet("/subCheck")
public class subCheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("memberId");

		mySubjectDAO dao = new mySubjectDAO();
		ArrayList<mySubjectDTO> list = dao.select(userId);

		// 18�й� ����
		int kicho = 6; // ����
		int hacksimeng = 48;
		int kidok = 8; // �⵶��
		int seke = 6; // ����ȭ
		int korean = 2; // ����
		int jeongbo = 2; // ����ȭ
		int mentor = 1; // ���丵
		int select = 10; // ���缱��
		int sum = 120;

		for (int i = 0; i < list.size(); i++) {
			mySubjectDTO dto = list.get(i);
			String classification = dto.getClassification();
			int credit = dto.getCredit();
			
			// 18 ����
			switch (classification) {
			case "�⵶���μ�":
				kicho -= credit;
				sum -= credit;
				break;
			case "����ȭ":
				seke -= credit;
				sum -= credit;
				break;
			case "����":
				korean -= credit;
				sum -= credit;
				break;
			case "����ȭ":
				jeongbo -= credit;
				sum -= credit;
				break;
			case "���丵":
				mentor -= credit;
				sum -= credit;
				break;
			case "���缱��":
				select -= credit;
				sum -= credit;
				break;
			case "���ʱ�����":
				kicho -= credit;
				sum -= credit;
				break;
			case "�ٽɱ�����":
				hacksimeng -= credit;
				sum -= credit;
				break;
			case "��ȭ������":
				hacksimeng -= credit;
				sum -= credit;
				break;
			case "���뱳����":
				hacksimeng -= credit;
				sum -= credit;
				break;
			}

		}
		request.setAttribute("kicho", kicho);
		request.setAttribute("hacksimeng", hacksimeng);
		request.setAttribute("kidok", kidok);
		request.setAttribute("seke", seke);
		request.setAttribute("korean", korean);
		request.setAttribute("jeongbo", jeongbo);
		request.setAttribute("mentor", mentor);
		request.setAttribute("select", select);
		request.setAttribute("sum", sum);
		
		RequestDispatcher rd = request.getRequestDispatcher("credit_residual.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}