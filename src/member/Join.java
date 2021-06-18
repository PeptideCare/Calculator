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
		
		// 학번이 아닐 시
		if ((id > 20500000) || ((id) < 20000000)){
			out.println("<script>");
			out.println("alert('학번을 정확하게 입력해주세요.');");
			out.println("location.href='join.jsp'");
			out.println("</script>");
		
		// 이미 가입 했을 시
		} else if (id == mId) {
			out.println("<script>");
			out.println("alert('이미 가입하신 회원입니다.');");
			out.println("location.href='login.jsp'");
			out.println("</script>");
			// 정상적인 회원가입
		} else {

			dao.insert(id, pw, name, department, major, schoolYear);

			out.println("<script>");
			out.println("alert('회원가입이 되었습니다.');");
			out.println("location.href='login.jsp'");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
