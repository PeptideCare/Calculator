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

		// 전공 과목

		String kicho[] = { "이산수학", "파이선 프로그래밍", "C언어프로그래밍" };
		String hack[] = { "JAVA 프로그래밍", "C언어 응용프로그래밍", "자료구조론", "창의기초프로젝트" };
		String simhwa[] = { "알고리즘", "운영체제론", "소프트웨어공학", "웹프로그래밍", "MFC프로그래밍", "UI/UX 디자인", "데이터통신", "데이터베이스 이론 및 실습",
				"창의응용프로젝트", "유닉스 프로그래밍", "JSP와 서블릿" };
		String engyoung[] = { "스마트폰 프로그래밍", "JAVA 응용 프로그래밍", "임베디드 시스템", "IOT응용", "캡스톤디자인" };

		String ckicho = "이산수학";
		String chack = "JAVA 프로그래밍";
		String csimhwa = "알고리즘";
		String cengyoung = "스마트폰 프로그래밍";

		HttpSession session = request.getSession();
		int mId = (int) session.getAttribute("memberId");

		mySubjectDAO sdao = new mySubjectDAO();
		ArrayList<mySubjectDTO> list = sdao.select(mId);

		for (int i = 0; i < list.size(); i++) {
			mySubjectDTO dto = list.get(i);
			String subjectName = dto.getSubjectName();
			String classifiaction = dto.getClassification();

			switch (classifiaction) {
			
			case "기초교과군":
				for (int j = 0; j < kicho.length; j++) {
					if (subjectName.equals(kicho[j])) {
						kicho[j] = null;
						break;
					}
				}
				break;

			case "핵심교과군":
				for (int j = 0; j < hack.length; j++) {
					if (subjectName.equals(hack[j])) {
						hack[j] = null;
						break;
					}
				}
				break;

			case "심화교과군":

				for (int j = 0; j < simhwa.length; j++) {
					if (subjectName.equals(simhwa[j])) {
						simhwa[j] = null;
						break;
					}
				}
				break;

			case "응용교과군":

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
