<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String ckicho = (String) request.getAttribute("ckicho");
	String chack = (String) request.getAttribute("chack");
	String csimhwa = (String) request.getAttribute("csimhwa");
	String cengyoung = (String) request.getAttribute("cengyoung");
%>

<!DOCTYPE html>
<html>

<head>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap"
	rel="stylesheet">
<title>전공 추천</title>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/styles.css">
</head>

<body>
	<a href='menu.jsp'><img src='./logo.PNG' id="logo_img"> </a>
	<div class="subtitle">
		전공 추천
		<div class="cource_lead_btn">
			<form action="recommend" method="get">
				<input type="submit" id='roadmap_btn' value="교양 추천">
			</form>
			<form action="recommendMajor" method="get">
				<input type="submit" id='roadmap_btn_checked' value="전공 추천">
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

			<div id="grid_division">기초교과군</div>
			<div id="grid_complete"><%=ckicho%></div>

			<div id="grid_division">핵심교과군</div>
			<div id="grid_complete"><%=chack%></div>

			<div id="grid_division">심화교과군</div>
			<div id="grid_complete"><%=csimhwa%></div>

			<div id="grid_division">응용교과군</div>
			<div id="grid_complete"><%=cengyoung%></div>
		</div>
	</div>
</body>