<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String csarang = (String)request.getAttribute("csarang");
	String cnonli = (String)request.getAttribute("cnonli");
	String cchang1 = (String)request.getAttribute("cchang1");
	String cboonya = (String)request.getAttribute("cboonya");
	String cbalpyo = (String)request.getAttribute("cbalpyo");
	String cglobal = (String)request.getAttribute("cglobal");
	String cforeign = (String)request.getAttribute("cforeign");
	String cjeongbo = (String)request.getAttribute("cjeongbo");
	String cmath = (String)request.getAttribute("cmath");
	String cbalance = (String)request.getAttribute("cbalance");
	String cchang2 = (String)request.getAttribute("cchang2");
	String cmentoring = (String)request.getAttribute("cmentoring");
	String csilyoung = (String)request.getAttribute("csilyoung");
	String cinsung = (String)request.getAttribute("cinsung");
%>

<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap" rel="stylesheet">
    <title>교양 추천</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./css/styles.css">
</head>

<body>
    <a href='menu.jsp'><img src='./logo.PNG' id="logo_img"> </a>
    <div class="subtitle">
        교양 추천
        <div class="cource_lead_btn">
            <form action="recommend" method="get">
            <input type="submit" id='roadmap_btn_checked' value="교양 추천" >
            </form>
            <a href="MR.jsp"><button id="roadmap_btn">전공 추천</button></a>
            <a href="https://www.bu.ac.kr/sites/web/files/sugang/2021_1_juyo.pdf"><button id="roadmap_btn">교양 로드맵</button></a>
            <a href="https://www.bu.ac.kr/sites/web/intro/down/2020_2_ict.pdf"><button id="roadmap_btn">전공 로드맵</button></a>
        </div>
    </div>

    <div class="grid">
        <div class="portalbtn">
            <a href="credit_input.jsp"><button class="unchecked_portal_btn>학점 입력"></button></a>
            <a href="credit_check.jsp"><button class="unchecked_portal_btn>나의 학점"></button></a>
            <a href="credit_residual.jsp"><button class="unchecked_portal_btn>남은 학점"></button></a>
            <a href="course_recom.jsp"><button class="checked_portal_btn">과목 추천</button></a>
            <form action="Logout", method="get">
            <input type="submit" id='logoutbtn' value="로그아웃" >
            </form>
        </div>
        <div class="inner_grid">
            <div id="grid_division_title">구분</div>
            <div id="grid_complete_title">추천과목</div>

            <div id="grid_division">사랑의 실천</div>
            <div id="grid_complete"><%=csarang%></div>

            <div id="grid_division">논리,비판적사고</div>
            <div id="grid_complete"><%=cnonli%></div>

            <div id="grid_division">창의,융합적사고</div>
            <div id="grid_complete"><%=cchang1%></div>

            <div id="grid_division">분야별 맞춤형 글쓰기</div>
            <div id="grid_complete"><%=cboonya%></div>

            <div id="grid_division">발표와토론</div>
            <div id="grid_complete"><%=cbalpyo%></div>
            
            <div id="grid_division">글로벌역량</div>
            <div id="grid_complete"><%=cglobal%></div>
            
            <div id="grid_division">기타외국어</div>
            <div id="grid_complete"><%=cforeign%></div>

            <div id="grid_division">정보기술</div>
            <div id="grid_complete"><%=cjeongbo%></div>

            <div id="grid_division">수학 및 기초과학</div>
            <div id="grid_complete"><%=cmath%></div>

            <div id="grid_division">균형교양</div>
            <div id="grid_complete"><%=cbalance%></div>
            
            <div id="grid_division">창의융합교양</div>
            <div id="grid_complete"><%=cchang2%></div>
            
            <div id="grid_division">멘토링</div>
            <div id="grid_complete"><%=cmentoring%></div>

            <div id="grid_division">협업 및 기타소양</div>
            <div id="grid_complete"><%=csilyoung%></div>

            <div id="grid_division">인성개발</div>
            <div id="grid_complete"><%=cinsung%></div>

        </div>
    </div>
</body>