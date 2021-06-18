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
import DAO.subjectDAO;
import DTO.memberDTO;
import DTO.mySubjectDTO;

@WebServlet("/recommend")
public class recommend extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 18�й� ���� �����
		String kidokyo[] = { "�⵶��Ž��", "�ΰ��� ���缺 Ž��", "����� �ΰ�����1", "����� �ΰ�����2", "�⵶�������", "�⵶����ġ�� ����", "����ٿ� ����� ��",
				"��� ������ ��ġ", "�̼� ��������Ʈ" };
		String sekehwa[] = { "���� �б�� ����", "���� ���� ���ϱ�", "���� ����ȸȭ" };
		String korean[] = { "���б�� �۾���", "����ǥ���� �۾���", "��ǥ�� ���" };
		String computer[] = { "���̼����α׷���", "���־��������α׷���" };
		String mentor[] = { "����Ƽ���", "����,��â���� ����" };
		String etc[] = { "�� ���̵��� â���ϱ�", "������ �ź�", "������", "�±ǵ��� �̷а� ����" };

		// 18�й� ���� �����
		String ckidokyo = "�⵶��Ž��";
		String csekehwa = "���� �б�� ����";
		String ckorean = "���б�� �۾���";
		String ccomputer = "���̼����α׷���";
		String cmentor = "����Ƽ���";
		String cetc = "�� ���̵��� â���ϱ�";

		// 18�й� ���� �����

		String sarang[] = { "�⵶��Ž��", "����� �ΰ�����1", "����� �ΰ�����2", "�⵶�������" };
		String nonli[] = { "�������� �ո�������", "������ ���ǰ� ����", "���� ǥ��" };
		String chang1[] = { "â�Ǽ��� �����ذ�", "�뼷�� ������ ���", "���а� ö���� ����" };
		String boonya[] = { "�ι���ȸ �۾���", "���б�� �۾���", "����ǥ���� �۾���" };
		String balpyo[] = { "��ǥ�� ���" };
		String global[] = { "���� �б�� ����", "���� ���� ���ϱ�", "���� ����ȸȭ" };
		String foreign[] = { "���� �߱�", "interview English", "���� �Ϻ���" };
		String jeongbo[] = { "���־����� ���α׷���", "���̼� ���α׷���" };
		String math[] = { "���м���", "�������� ����", "�������� ����" };
		String balance[] = { "������ ����", "���蹮ȭ��", "������ �μӹ�ȭ", "������", "��Ȱ�� ����", "�ѱ���Ž��", "�����", "�����Ⱥ���" };
		String chang2[] = { "�����ȸ�����Ӱ��� ��ȸŽ��", "�ڱ����ؿ� �̷�������" };
		String mentoring[] = { "���л�Ȱ�� ����", "Ŀ�����", "����Ƽ���", "����,��â���� ����" };
		String silyoung[] = { "������ ���ݻ��", "ǲ���� �̷а� ����" };
		String insung[] = { "�μ��� ���ΰ���", "������ ������", "��ȸ����", "Ŀ���� ������" };

		// 18�й� ���� �����

		String csarang = "�⵶��Ž��";
		String cnonli = "�������� �ո�������";
		String cchang1 = "â�Ǽ��� �����ذ�";
		String cboonya = "�ι���ȸ �۾���";
		String cbalpyo = "��ǥ�� ���";
		String cglobal = "���� �б�� ����";
		String cforeign = "���� �߱�";
		String cjeongbo = "���־����� ���α׷���";
		String cmath = "���м���";
		String cbalance = "������ ����";
		String cchang2 = "�����ȸ�����Ӱ��� ��ȸŽ��";
		String cmentoring = "���л�Ȱ�� ����";
		String csilyoung = "������ ���ݻ��";
		String cinsung = "�μ��� ���ΰ���";

		HttpSession session = request.getSession();
		int schoolYear = (int) session.getAttribute("schoolYear");
		int mId = (int) session.getAttribute("memberId");

		mySubjectDAO sdao = new mySubjectDAO();

		ArrayList<mySubjectDTO> list = sdao.select(mId);

		// 18�й� ����
//		if (schoolYear <= 18) {
			for (int i = 0; i < list.size(); i++) {
				mySubjectDTO dto = list.get(i);
				String subjectName = dto.getSubjectName();
				String classifiaction = dto.getClassification();

				switch (classifiaction) {
				case "�⵶���μ�":
					for (int j = 0; j < kidokyo.length; j++) {
						if (subjectName.equals(kidokyo[j])) {
							kidokyo[j] = null;
							break;
						}
					}
					
					break;

				case "����ȭ":
					for (int j = 0; j < sekehwa.length; j++) {
						if (subjectName.equals(sekehwa[j])) {
							sekehwa[j] = null;
							break;
						}
					}
					break;

				case "����":

					for (int j = 0; j < korean.length; j++) {
						if (subjectName.equals(korean[j])) {
							korean[j] = null;
							break;
						}
					}
					break;

				case "����ȭ":

					for (int j = 0; j < computer.length; j++) {
						if (subjectName.equals(computer[j])) {
							computer[j] = null;
							break;
						}
					}
					break;

				case "���丵":

					for (int j = 0; j < mentor.length; j++) {
						if (subjectName.equals(mentor[j])) {
							mentor[j] = null;
							break;
						}
					}
					break;
					
				case "���缱��":
					for (int j = 0; j < etc.length; j++) {
						if (subjectName.equals(etc[j])) {
							etc[j] = null;
							break;
						}
					}
					break;
				}
				
				for (int j = 0; j < kidokyo.length; j++) {
					if (kidokyo[j] != null) {
						ckidokyo = kidokyo[j];
					}
				}
				for (int j = 0; j < sekehwa.length; j++) {
					if (sekehwa[j] != null) {
						csekehwa = sekehwa[j];
					}
				}
				for (int j = 0; j < korean.length; j++) {
					if (korean[j] != null) {
						ckorean = korean[j];
					}
				}
				for (int j = 0; j < computer.length; j++) {
					if (computer[j] != null) {
						ccomputer = computer[j];
					}
				}
				for (int j = 0; j < mentor.length; j++) {
					if (mentor[j] != null) {
						cmentor = mentor[j];
					}
				}
				for (int j = 0; j < sekehwa.length; j++) {
					if (sekehwa[j] != null) {
						csekehwa = sekehwa[j];
					}
				}
				for (int j = 0; j < etc.length; j++) {
					if (etc[j] != null) {
						cetc = etc[j];
					}
				}
			}

			request.setAttribute("kidokyo", ckidokyo);
			request.setAttribute("csekehwa", csekehwa);
			request.setAttribute("ckorean", ckorean);
			request.setAttribute("ccomputer", ccomputer);
			request.setAttribute("cmentor", cmentor);
			request.setAttribute("cetc", cetc);

			RequestDispatcher rd = request.getRequestDispatcher("course_recom.jsp");
			rd.forward(request, response);
		}

//		// 18�й� ����
//		else {
//			for (int i = 0; i < list.size(); i++) {
//				mySubjectDTO dto = list.get(i);
//				String subjectName = dto.getSubjectName();
//				String classifiaction = dto.getClassification();
//
//				switch (classifiaction) {
//				case "����ǽ�õ":
//					for (int j = 0; j < sarang.length; j++) {
//						if (subjectName.equals(sarang[j])) {
//							csarang = sarang[j];
//							break;
//						}
//					}
//					break;
//
//				case "��,���������":
//					for (int j = 0; j < nonli.length; j++) {
//						if (subjectName.equals(nonli[j])) {
//							cnonli = nonli[j];
//							break;
//						}
//					}
//					break;
//
//				case "â��,���������":
//
//					for (int j = 0; j < chang1.length; j++) {
//						if (subjectName.equals(chang1[j])) {
//							cchang1 = chang1[j];
//							break;
//						}
//					}
//					break;
//
//				case "�оߺ� ������ �۾���":
//
//					for (int j = 0; j < boonya.length; j++) {
//						if (!subjectName.equals(boonya[j])) {
//							cboonya = boonya[j];
//							break;
//						}
//					}
//					break;
//
//				case "��ǥ�����":
//
//					for (int j = 0; j < balpyo.length; j++) {
//						if (!subjectName.equals(balpyo[j])) {
//							cbalpyo = balpyo[j];
//							break;
//						}
//					}
//					break;
//
//				case "�۷ι�����":
//
//					for (int j = 0; j < global.length; j++) {
//						if (!subjectName.equals(global[j])) {
//							cglobal = global[j];
//							break;
//						}
//					}
//					break;
//
//				case "��Ÿ�ܱ���":
//
//					for (int j = 0; j < foreign.length; j++) {
//						if (!subjectName.equals(foreign[j])) {
//							cforeign = foreign[j];
//							break;
//						}
//					}
//					break;
//
//				case "�������":
//
//					for (int j = 0; j < jeongbo.length; j++) {
//						if (!subjectName.equals(jeongbo[j])) {
//							cjeongbo = jeongbo[j];
//							break;
//						}
//					}
//					break;
//
//				case "���� �� ���ʰ���":
//
//					for (int j = 0; j < math.length; j++) {
//						if (!subjectName.equals(math[j])) {
//							cmath = math[j];
//							break;
//						}
//					}
//					break;
//
//				case "��������":
//
//					for (int j = 0; j < balance.length; j++) {
//						if (!subjectName.equals(balance[j])) {
//							cbalance = balance[j];
//							break;
//						}
//					}
//					break;
//
//				case "â�����ձ���":
//
//					for (int j = 0; j < chang2.length; j++) {
//						if (!subjectName.equals(chang2[j])) {
//							cchang2 = chang2[j];
//							break;
//						}
//					}
//					break;
//
//				case "���丵":
//
//					for (int j = 0; j < mentoring.length; j++) {
//						if (!subjectName.equals(mentoring[j])) {
//							cmentoring = mentoring[j];
//							break;
//						}
//					}
//					break;
//
//				case "���� �� ��Ÿ�Ҿ�":
//
//					for (int j = 0; j < silyoung.length; j++) {
//						if (!subjectName.equals(silyoung[j])) {
//							csilyoung = silyoung[j];
//							break;
//						}
//					}
//					break;
//
//				case "�μ�����":
//
//					for (int j = 0; j < insung.length; j++) {
//						if (!subjectName.equals(insung[j])) {
//							cinsung = insung[j];
//							break;
//						}
//					}
//					break;
//				}
//			}
//			
//			request.setAttribute("csarang", csarang);
//			request.setAttribute("cnonli", cnonli);
//			request.setAttribute("cchang1", cchang1);
//			request.setAttribute("cboonya", cboonya);
//			request.setAttribute("cbalpyo", cbalpyo);
//			request.setAttribute("cglobal", cglobal);
//			request.setAttribute("cforeign", cforeign);
//			request.setAttribute("cjeongbo", cjeongbo);
//			request.setAttribute("cmath", cmath);
//			request.setAttribute("cbalance", cbalance);
//			request.setAttribute("cchang2", cchang2);
//			request.setAttribute("cmentoring", cmentoring);
//			request.setAttribute("csilyoung", csilyoung);
//			request.setAttribute("cinsung", cinsung);
//
//			RequestDispatcher rd = request.getRequestDispatcher("LAR.jsp");
//			rd.forward(request, response);
			

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
