<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>

<body>
	&nbsp;
	<a href='main.jsp'> <img src='logo.PNG'>
	</a>
	<center>
		<font size='6'><b> 회원가입 </b></font> <br> <br>
		<hr>
		<br> <br>

		<table border='1' bordercolor='#BDBDBD' width='400' height='400'
			cellspacing='0'>
			<tr>
				<td align='center'>
					<form action="Join" method="post">
						<!--db와 연결-->
						이&nbsp;&nbsp;&nbsp;름 <input type="text" name="name"><br>
						<br> 학번 <input type="number" name="id"><br> <br>
						<!--db연동-->
						비밀번호 <input type="password" name="pw"><br> <br>
						<!--db연동-->
						학&nbsp;&nbsp;&nbsp;부 <select name="department">
							<option value="기독교학부">기독교학부</option>
							<option value="어문학부">어문학부</option>
							<option value="사회복지학부">사회복지학부</option>
							<option value="경찰학부">경찰학부</option>
							<option value="경상학부">경상학부</option>
							<option value="관광학부">관광학부</option>
							<option value="사범학부">사범학부</option>
							<option value="컴퓨터공학부">컴퓨터공학부</option>
							<option value="보건학부">보건학부</option>
							<option value="간호학부">간호학부</option>
							<option value="디자인영상학부">디자인영상학부</option>
							<option value="스포츠과학부">스포츠과학부</option>
							<option value="기타">기&nbsp;&nbsp;&nbsp;타</option>
						</select> <br> <br> 학&nbsp;&nbsp;&nbsp;과 (예. 소프트웨어학과)<br> <input
							type="text" name="major"><br> <br>
						<!--db연동-->
						학&nbsp;&nbsp;&nbsp;년<br> <input type="radio"
							name="schoolYear" value="1">1학년
						<!--db연동-->
						<input type="radio" name="schoolYear" value="2"> 2학년
						<!--db연동-->
						<input type="radio" name="schoolYear" value="3"> 3학년
						<!--db연동-->
						<input type="radio" name="schoolYear" value="4"> 4학년<br>
						<!--db연동-->
				</td>
			</tr>
		</table>
		<br> <input type=submit value="회원가입">
		</form>

		<br> <br> <br> <br>

	</center>

</body>


</html>