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

		// 18학번 이전 과목들
		String kidokyo[] = { "기독교탐사", "인간의 존재성 탐구", "성경과 인간이해1", "성경과 인간이해2", "기독교세계관", "기독교가치와 윤리", "사람다운 사람의 길",
				"삶과 직업의 가치", "미션 다이제스트" };
		String sekehwa[] = { "영어 읽기와 쓰기", "영어 듣기와 말하기", "실전 영어회화" };
		String korean[] = { "과학기술 글쓰기", "예술표현과 글쓰기", "발표와 토론" };
		String computer[] = { "파이선프로그래밍", "비주얼베이직프로그래밍" };
		String mentor[] = { "프런티어십", "성공,취창업과 진로" };
		String etc[] = { "내 아이디어로 창업하기", "생명의 신비", "보건학", "태권도의 이론과 실제" };

		// 18학번 이전 과목들
		String ckidokyo = "기독교탐사";
		String csekehwa = "영어 읽기와 쓰기";
		String ckorean = "과학기술 글쓰기";
		String ccomputer = "파이선프로그래밍";
		String cmentor = "프런티어십";
		String cetc = "내 아이디어로 창업하기";

		// 18학번 이후 과목들

		String sarang[] = { "기독교탐사", "성경과 인간이해1", "성경과 인간이해2", "기독교세계관" };
		String nonli[] = { "논리적사고와 합리적비판", "과학의 진실과 오류", "사고와 표현" };
		String chang1[] = { "창의성과 문제해결", "통섭과 융합적 사고", "과학과 철학의 만남" };
		String boonya[] = { "인문사회 글쓰기", "과학기술 글쓰기", "예술표현과 글쓰기" };
		String balpyo[] = { "발표와 토론" };
		String global[] = { "영어 읽기와 쓰기", "영어 듣기와 말하기", "실전 영어회화" };
		String foreign[] = { "토픽 중급", "interview English", "대학 일본어" };
		String jeongbo[] = { "비주얼베이직 프로그래밍", "파이선 프로그래밍" };
		String math[] = { "대학수학", "생물학의 이해", "물리학의 이해" };
		String balance[] = { "문학의 이해", "세계문화사", "세계의 민속문화", "여성학", "생활과 법률", "한국사탐방", "전쟁사", "국가안보론" };
		String chang2[] = { "위기사회와지속가능 사회탐색", "자기이해와 미래디자인" };
		String mentoring[] = { "대학생활과 진로", "커리어개발", "프런티어십", "성공,취창업과 진로" };
		String silyoung[] = { "금융과 세금상식", "풋살의 이론과 실제" };
		String insung[] = { "인성과 대인관계", "섬김의 리더십", "사회봉사", "커리어 리더십" };

		// 18학번 이후 과목들

		String csarang = "기독교탐사";
		String cnonli = "논리적사고와 합리적비판";
		String cchang1 = "창의성과 문제해결";
		String cboonya = "인문사회 글쓰기";
		String cbalpyo = "발표와 토론";
		String cglobal = "영어 읽기와 쓰기";
		String cforeign = "토픽 중급";
		String cjeongbo = "비주얼베이직 프로그래밍";
		String cmath = "대학수학";
		String cbalance = "문학의 이해";
		String cchang2 = "위기사회와지속가능 사회탐색";
		String cmentoring = "대학생활과 진로";
		String csilyoung = "금융과 세금상식";
		String cinsung = "인성과 대인관계";

		HttpSession session = request.getSession();
		int schoolYear = (int) session.getAttribute("schoolYear");
		int mId = (int) session.getAttribute("memberId");

		mySubjectDAO sdao = new mySubjectDAO();

		ArrayList<mySubjectDTO> list = sdao.select(mId);

		// 18학번 이전
//		if (schoolYear <= 18) {
			for (int i = 0; i < list.size(); i++) {
				mySubjectDTO dto = list.get(i);
				String subjectName = dto.getSubjectName();
				String classifiaction = dto.getClassification();

				switch (classifiaction) {
				case "기독교인성":
					for (int j = 0; j < kidokyo.length; j++) {
						if (subjectName.equals(kidokyo[j])) {
							kidokyo[j] = null;
							break;
						}
					}
					
					break;

				case "세계화":
					for (int j = 0; j < sekehwa.length; j++) {
						if (subjectName.equals(sekehwa[j])) {
							sekehwa[j] = null;
							break;
						}
					}
					break;

				case "국어":

					for (int j = 0; j < korean.length; j++) {
						if (subjectName.equals(korean[j])) {
							korean[j] = null;
							break;
						}
					}
					break;

				case "정보화":

					for (int j = 0; j < computer.length; j++) {
						if (subjectName.equals(computer[j])) {
							computer[j] = null;
							break;
						}
					}
					break;

				case "멘토링":

					for (int j = 0; j < mentor.length; j++) {
						if (subjectName.equals(mentor[j])) {
							mentor[j] = null;
							break;
						}
					}
					break;
					
				case "교양선택":
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

//		// 18학번 이후
//		else {
//			for (int i = 0; i < list.size(); i++) {
//				mySubjectDTO dto = list.get(i);
//				String subjectName = dto.getSubjectName();
//				String classifiaction = dto.getClassification();
//
//				switch (classifiaction) {
//				case "사랑의실천":
//					for (int j = 0; j < sarang.length; j++) {
//						if (subjectName.equals(sarang[j])) {
//							csarang = sarang[j];
//							break;
//						}
//					}
//					break;
//
//				case "논리,비판적사고":
//					for (int j = 0; j < nonli.length; j++) {
//						if (subjectName.equals(nonli[j])) {
//							cnonli = nonli[j];
//							break;
//						}
//					}
//					break;
//
//				case "창의,융합적사고":
//
//					for (int j = 0; j < chang1.length; j++) {
//						if (subjectName.equals(chang1[j])) {
//							cchang1 = chang1[j];
//							break;
//						}
//					}
//					break;
//
//				case "분야별 맞춤형 글쓰기":
//
//					for (int j = 0; j < boonya.length; j++) {
//						if (!subjectName.equals(boonya[j])) {
//							cboonya = boonya[j];
//							break;
//						}
//					}
//					break;
//
//				case "발표와토론":
//
//					for (int j = 0; j < balpyo.length; j++) {
//						if (!subjectName.equals(balpyo[j])) {
//							cbalpyo = balpyo[j];
//							break;
//						}
//					}
//					break;
//
//				case "글로벌영략":
//
//					for (int j = 0; j < global.length; j++) {
//						if (!subjectName.equals(global[j])) {
//							cglobal = global[j];
//							break;
//						}
//					}
//					break;
//
//				case "기타외국어":
//
//					for (int j = 0; j < foreign.length; j++) {
//						if (!subjectName.equals(foreign[j])) {
//							cforeign = foreign[j];
//							break;
//						}
//					}
//					break;
//
//				case "정보기술":
//
//					for (int j = 0; j < jeongbo.length; j++) {
//						if (!subjectName.equals(jeongbo[j])) {
//							cjeongbo = jeongbo[j];
//							break;
//						}
//					}
//					break;
//
//				case "수학 및 기초과학":
//
//					for (int j = 0; j < math.length; j++) {
//						if (!subjectName.equals(math[j])) {
//							cmath = math[j];
//							break;
//						}
//					}
//					break;
//
//				case "균형교양":
//
//					for (int j = 0; j < balance.length; j++) {
//						if (!subjectName.equals(balance[j])) {
//							cbalance = balance[j];
//							break;
//						}
//					}
//					break;
//
//				case "창의융합교양":
//
//					for (int j = 0; j < chang2.length; j++) {
//						if (!subjectName.equals(chang2[j])) {
//							cchang2 = chang2[j];
//							break;
//						}
//					}
//					break;
//
//				case "멘토링":
//
//					for (int j = 0; j < mentoring.length; j++) {
//						if (!subjectName.equals(mentoring[j])) {
//							cmentoring = mentoring[j];
//							break;
//						}
//					}
//					break;
//
//				case "협업 및 기타소양":
//
//					for (int j = 0; j < silyoung.length; j++) {
//						if (!subjectName.equals(silyoung[j])) {
//							csilyoung = silyoung[j];
//							break;
//						}
//					}
//					break;
//
//				case "인성개발":
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
