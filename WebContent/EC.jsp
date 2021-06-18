<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap" rel="stylesheet">
    <title>과목 등록</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./css/styles.css">
</head>

<body>
    <a href='menu.jsp'><img src='./logo.PNG' id="logo_img"> </a>
    <div class="subtitle">
        과목 등록
    </div>

    <div class = "grid">
        <div class="portalbtn">
            <a href="EC.jsp"><button class="checked_portal_btn">과목 등록</button></a>
            <a href="CD.jsp"><button class="unchecked_portal_btn">과목 삭제</button></a>
            <form action="Logout", method="get">
            <input type="submit" id='logoutbtn' value="로그아웃" >
            </form>
        </div>

        <div class="Subject_enter_form">
            <form action = "insertSubject" method = "post" id = "input_subject_info_form">
                <div class="Subject_enter_select">
                    	학과 : <select name="className" id="className">
                        <option value="소프트웨어">소프트웨어</option>
                        <option value="정보보안">정보보안</option>
                        <option value="정보통신">정보통신</option>
                    </select><br>
                   이수구분(18학번 이후) : <select name="before18" id="before18">
                        <option value="기초">기초교과군</option>
                        <option value="핵심">핵심교과군</option>
                        <option value="심화">심화교과군</option>
                        <option value="응용">응용교과군</option>
                        <option value="대학예배">대학예배</option>
                        <option value="기독교인성">기독교인성</option>
                        <option value="세계화">세계화</option>
                        <option value="국어">국어</option>
                        <option value="정보화">정보화</option>
                        <option value="멘토링">멘토링</option>
                        <option value="교양선택">교양선택</option>
                    </select><br>
                     이수구분(18학번 이전) : <select name="classification" id="classification">
                        <option value="기초">기초교과군</option>
                        <option value="핵심">핵심교과군</option>
                        <option value="심화">심화교과군</option>
                        <option value="응용">응용교과군</option>
                        <option value="채플과섬김">채플과섬김</option>
                        <option value="사랑의실천">사랑의실천</option>
                        <option value="논리">논리,비판적사고</option>
                        <option value="창의">창의,융합적사고</option>
                        <option value="분야별">분야별 맞춤형 글쓰기</option>
                        <option value="발표와토론">발표와토론</option>
                        <option value="글로벌역량">글로벌역량</option>
                        <option value="기타외국어">기타외국어</option>
                        <option value="정보기술">정보기술</option>
                        <option value="수학">수학 및 기초과학</option>
                        <option value="균형교양">균형교양</option>
                        <option value="창의융합교양">창의융합교양</option>
                        <option value="멘토링">멘토링</option>
                        <option value="협업">협업 및 기타소양</option>
                        <option value="인성개발">인성개발</option>
                    </select><br>
                    학점 : <select name="credit" id="credit">
                        <option value="0">0</option>
                        <option value="0.5">0.5</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select><br>
                </div>
                <div class="Subject_enter_text">
                    과목명 : <input type="text" id="text" name="name" size="20" placeholder="과목명(18학번 이후)"
                        onfocus="this.placeholder=''" onblur="this.placeholder='과목명(18학번 이후)'">
                        <input type="text" id="text" name="nameBefore" size="20" placeholder="과목명(18학번 이전)"
                        onfocus="this.placeholder=''" onblur="this.placeholder='과목명(18학번 이전)'">
                    과목코드 : <input type="text" id="text" name="code" size="20" placeholder="과목코드를 입력하세요"
                        onfocus="this.placeholder=''" onblur="this.placeholder='과목코드를 입력하세요'">
                        교수명 : <input type="text" id="text" name="professorName" size="20" placeholder="교수명을 입력하세요"
                        onfocus="this.placeholder=''" onblur="this.placeholder='교수명을 입력하세요'">
                         권장학년 : <select name="year" id="year">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select><br>
                </div>
                <div class="Subject_enter_time">
                    시간 : <select name="hour" id="hour">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select><br>
                </div>
                <input type="submit" name="Add_subject">
            </form>
        </div>
    </div>

</body>

</html>