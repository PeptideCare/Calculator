<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String kidokyo = (String) request.getAttribute("kidokyo");
String csekehwa = (String) request.getAttribute("csekehwa");
String ckorean = (String) request.getAttribute("ckorean");
String ccomputer = (String) request.getAttribute("ccomputer");
String cmentor = (String) request.getAttribute("cmentor");
String cetc = (String) request.getAttribute("cetc");
%>
<!DOCTYPE html>
<html>

<head>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap"
	rel="stylesheet">
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
				<input type="submit" id='roadmap_btn_checked' value="교양 추천">
			</form>
			<form action="recommendMajor" method="get">
				<input type="submit" id='roadmap_btn' value="전공 추천">
			</form>
			<a href="https://www.bu.ac.kr/sites/web/files/sugang/2021_1_juyo.pdf"><button
					id="roadmap_btn">교양 로드맵</button></a> <a
				href="https://www.bu.ac.kr/sites/web/intro/down/2020_2_ict.pdf"><button
					id="roadmap_btn">전공 로드맵</button></a>
		</div>
	</div>

	<div class="grid">
		<div class="portalbtn">
			<a href="credit_input.jsp"><button class="unchecked_portal_btn">학점
					입력</button></a>
			<form action="gradeCheck" , method="get">
				<input type="submit" class='unchecked_portal_btn' value="학점관리">
			</form>
			<form action="subCheck" , method="get">
				<input type="submit" class='unchecked_portal_btn' value="남은학점">
			</form>
			<form action="recommend" , method="get">
				<input type="submit" class='checked_portal_btn' value="과목추천">
			</form>
			<form action="Logout" , method="get">
				<input type="submit" id='logoutbtn' value="로그아웃">
			</form>
		</div>
		<div class="inner_grid">
			<div id="grid_division_title">구분</div>
			<div id="grid_complete_title">추천과목</div>

			<div id="grid_division">기독교 인성</div>
			<div id="grid_complete"><%=kidokyo%></div>

			<div id="grid_division">세계화</div>
			<div id="grid_complete"><%=csekehwa%></div>

			<div id="grid_division">국어</div>
			<div id="grid_complete"><%=ckorean%></div>

			<div id="grid_division">정보화</div>
			<div id="grid_complete"><%=ccomputer%></div>

			<div id="grid_division">백석 멘토링</div>
			<div id="grid_complete"><%=cmentor%></div>

			<div id="grid_division">교양 선택</div>
			<div id="grid_complete"><%=cetc%></div>
		</div>
	</div>
</body>