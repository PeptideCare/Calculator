package mySubject;

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

@WebServlet("/recommendMajor")
public class recommendMajor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// ���� ����

		String kicho[] = { "�̻����", "���̼� ���α׷���", "C������α׷���" };
		String hack[] = { "JAVA ���α׷���", "C��� �������α׷���", "�ڷᱸ����", "â�Ǳ���������Ʈ" };
		String simhwa[] = { "�˰���", "�ü����", "����Ʈ�������", "�����α׷���", "MFC���α׷���", "UI/UX ������", "���������", "�����ͺ��̽� �̷� �� �ǽ�",
				"â������������Ʈ", "���н� ���α׷���", "JSP�� ����" };
		String engyoung[] = { "����Ʈ�� ���α׷���", "JAVA ���� ���α׷���", "�Ӻ���� �ý���", "IOT����", "ĸ���������" };

		String ckicho = "�̻����";
		String chack = "JAVA ���α׷���";
		String csimhwa = "�˰���";
		String cengyoung = "����Ʈ�� ���α׷���";

		HttpSession session = request.getSession();
		int mId = (int) session.getAttribute("memberId");

		mySubjectDAO sdao = new mySubjectDAO();
		ArrayList<mySubjectDTO> list = sdao.select(mId);

		for (int i = 0; i < list.size(); i++) {
			mySubjectDTO dto = list.get(i);
			String subjectName = dto.getSubjectName();
			String classifiaction = dto.getClassification();

			switch (classifiaction) {
			
			case "���ʱ�����":
				for (int j = 0; j < kicho.length; j++) {
					if (subjectName.equals(kicho[j])) {
						kicho[j] = null;
						break;
					}
				}
				break;

			case "�ٽɱ�����":
				for (int j = 0; j < hack.length; j++) {
					if (subjectName.equals(hack[j])) {
						hack[j] = null;
						break;
					}
				}
				break;

			case "��ȭ������":

				for (int j = 0; j < simhwa.length; j++) {
					if (subjectName.equals(simhwa[j])) {
						simhwa[j] = null;
						break;
					}
				}
				break;

			case "���뱳����":

				for (int j = 0; j < engyoung.length; j++) {
					if (subjectName.equals(engyoung[j])) {
						engyoung[j] = null;
						break;
					}
				}
				break;
			}
			
			for (int j = 0; j < kicho.length; j++) {
				if (kicho[j] != null) {
					ckicho = kicho[j];
				}
			}
			for (int j = 0; j < hack.length; j++) {
				if (hack[j] != null) {
					chack = hack[j];
				}
			}
			for (int j = 0; j < simhwa.length; j++) {
				if (simhwa[j] != null) {
					csimhwa = simhwa[j];
				}
			}
			for (int j = 0; j < engyoung.length; j++) {
				if (engyoung[j] != null) {
					cengyoung = engyoung[j];
				}
			}
		}
		
		request.setAttribute("ckicho", ckicho);
		request.setAttribute("chack", chack);
		request.setAttribute("csimhwa", csimhwa);
		request.setAttribute("cengyoung", cengyoung);

		RequestDispatcher rd = request.getRequestDispatcher("MR.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
