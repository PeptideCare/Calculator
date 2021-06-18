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

		// 18학번 이전
		int kicho = 6; // 기초
		int hacksimeng = 48;
		int kidok = 8; // 기독교
		int seke = 6; // 세계화
		int korean = 2; // 국어
		int jeongbo = 2; // 정보화
		int mentor = 1; // 멘토링
		int select = 10; // 교양선택
		int sum = 120;

		for (int i = 0; i < list.size(); i++) {
			mySubjectDTO dto = list.get(i);
			String classification = dto.getClassification();
			int credit = dto.getCredit();
			
			// 18 이전
			switch (classification) {
			case "기독교인성":
				kicho -= credit;
				sum -= credit;
				break;
			case "세계화":
				seke -= credit;
				sum -= credit;
				break;
			case "국어":
				korean -= credit;
				sum -= credit;
				break;
			case "정보화":
				jeongbo -= credit;
				sum -= credit;
				break;
			case "멘토링":
				mentor -= credit;
				sum -= credit;
				break;
			case "교양선택":
				select -= credit;
				sum -= credit;
				break;
			case "기초교과군":
				kicho -= credit;
				sum -= credit;
				break;
			case "핵심교과군":
				hacksimeng -= credit;
				sum -= credit;
				break;
			case "심화교과군":
				hacksimeng -= credit;
				sum -= credit;
				break;
			case "응용교과군":
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