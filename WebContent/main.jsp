<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> 메인화면 </title>
        <style>
        #btn_group button {
            width:100px;
            border: 1px;
            background-color:#616161;
            padding: 15px 0;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 4px;
            color: #ffffff;
            cursor: pointer;
        }
        </style>
    </head>

    <body>
    	<%
			if(session.getAttribute("memberId") != null)
				response.sendRedirect("menu.jsp");
		%>
    
        &nbsp; <img src='logo.PNG'>
        <center> <font size='7'><b>백석대학교 학점 관리 사이트 </b></font> <br><br>
        <hr>
        <br><br><br><br>

        <div id="btn_group">
            <button id="join"><a onclick="location.href='login.jsp'">로그인</a></button><br><br>
            <button id="login"><a onclick="location.href='join.jsp'">회원가입</a></button>
        </div>
        </center>
    </body>
</html>