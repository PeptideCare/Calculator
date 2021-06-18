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

		// 18학번 이전
		int kicho = 0; // 기초
		int hack = 0; // 핵심
		int sim = 0; // 심화
		int eng = 0; // 응용
		int kidok = 0; // 기독교
		int seke = 0; // 세계화
		int korean = 0; // 국어
		int jeongbo = 0; // 정보화
		int mentor = 0; // 멘토링
		int select = 0; // 교양선택

		// 18학번 이후
		int gyo = 0; // 교양

		int major = 0; // 전공

		for (int i = 0; i < list.size(); i++) {
			mySubjectDTO dto = list.get(i);
			String classification = dto.getClassification();
			int credit = dto.getCredit();

			// 18 이전
			switch (classification) {
			case "기독교인성":
				kicho += credit;
				break;
			case "세계화":
				seke += credit;
				break;
			case "국어":
				korean += credit;
				break;
			case "정보화":
				jeongbo += credit;
				break;
			case "멘토링":
				mentor += credit;
				break;
			case "교양선택":
				select += credit;
				break;
			case "기초교과군":
				kicho += credit;
				break;
			case "핵심교과군":
				hack += credit;
				break;
			case "심화교과군":
				sim += credit;
				break;
			case "응용교과군":
				eng += credit;
				break;
			}

//			case "사랑의실천":
//			case "논리,비판적사고":
//			case "창의,융합적사고":
//			case "분야별 맞춤형 글쓰기":
//			case "발표와토론":
//			case "글로벌영략":
//			case "기타외국어":
//			case "정보기술":
//			case "수학 및 기초과학":
//			case "균형교양":
//			case "창의융합교양":
//			case "멘토링":
//			case "협업 및 기타소양":
//			case "인성개발":
//				gyo += dto.getCredit();
//				break;
//
//			case "기초교과군":
//			case "핵심교과군":
//			case "심화교과군":
//			case "응용교과군":
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
