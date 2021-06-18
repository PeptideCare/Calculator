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

@WebServlet("/gradeCheck")
public class gradeCheck extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("memberId");
		int schoolYear = (int) session.getAttribute("schoolYear");

		mySubjectDAO dao = new mySubjectDAO();
		ArrayList<mySubjectDTO> list = dao.select(userId);

		// 18�й� ����
		int kicho = 0; // ����
		int hack = 0; // �ٽ�
		int sim = 0; // ��ȭ
		int eng = 0; // ����
		int kidok = 0; // �⵶��
		int seke = 0; // ����ȭ
		int korean = 0; // ����
		int jeongbo = 0; // ����ȭ
		int mentor = 0; // ���丵
		int select = 0; // ���缱��

		// 18�й� ����
		int gyo = 0; // ����

		int major = 0; // ����

		for (int i = 0; i < list.size(); i++) {
			mySubjectDTO dto = list.get(i);
			String classification = dto.getClassification();
			int credit = dto.getCredit();

			// 18 ����
			switch (classification) {
			case "�⵶���μ�":
				kicho += credit;
				break;
			case "����ȭ":
				seke += credit;
				break;
			case "����":
				korean += credit;
				break;
			case "����ȭ":
				jeongbo += credit;
				break;
			case "���丵":
				mentor += credit;
				break;
			case "���缱��":
				select += credit;
				break;
			case "���ʱ�����":
				kicho += credit;
				break;
			case "�ٽɱ�����":
				hack += credit;
				break;
			case "��ȭ������":
				sim += credit;
				break;
			case "���뱳����":
				eng += credit;
				break;
			}

//			case "����ǽ�õ":
//			case "��,���������":
//			case "â��,���������":
//			case "�оߺ� ������ �۾���":
//			case "��ǥ�����":
//			case "�۷ι�����":
//			case "��Ÿ�ܱ���":
//			case "�������":
//			case "���� �� ���ʰ���":
//			case "��������":
//			case "â�����ձ���":
//			case "���丵":
//			case "���� �� ��Ÿ�Ҿ�":
//			case "�μ�����":
//				gyo += dto.getCredit();
//				break;
//
//			case "���ʱ�����":
//			case "�ٽɱ�����":
//			case "��ȭ������":
//			case "���뱳����":
//				major += dto.getCredit();
//
//			default:
//				gyoC += dto.getCredit();
//				break;
//			}
//		}

		}
		request.setAttribute("kicho", kicho);
		request.setAttribute("hack", hack);
		request.setAttribute("sim", sim);
		request.setAttribute("eng", eng);
		request.setAttribute("kidok", kidok);
		request.setAttribute("seke", seke);
		request.setAttribute("korean", korean);
		request.setAttribute("jeongbo", jeongbo);
		request.setAttribute("mentor", mentor);
		request.setAttribute("select", select);

		RequestDispatcher rd = request.getRequestDispatcher("credit_check.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
