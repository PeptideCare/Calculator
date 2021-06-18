<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@800&display=swap" rel="stylesheet">
    <title>과목삭제</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./css/styles.css">
</head>

<body>
<a href='menu.jsp'><img src='./logo.PNG' id="logo_img"> </a>
    <div class="subtitle">
        과목 삭제
    </div>

    <div class="grid">
        <div class="portalbtn">
            <a href="EC.jsp"><button class="unchecked_portal_btn">과목 등록</button></a>
            <a href="CD.jsp"><button class="checked_portal_btn">과목 삭제</button></a>
            <form action="Logout", method="get">
            <input type="submit" id='logoutbtn' value="로그아웃" >
            </form>
        </div>

        <div class="Subject_delete_form">
            <form action = "deleteSubject" method = "post">
                <input type="text" name="name" size="20" placeholder="과목명을 입력하세요"
                    onfocus="this.placeholder=''" onblur="this.placeholder='과목명을 입력하세요'">
                <input type="text" name="code" size="20" placeholder="과목코드를 입력하세요"
                    onfocus="this.placeholder=''" onblur="this.placeholder='과목코드를 입력하세요'">
                <input type="submit" value="삭제">
            </form>
        </div>
    </div>

</body>

</html>