<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> 로그인 </title>
        <style>
            #login {
                width:70px;
                border: 1px;
                background-color:#616161;
                padding: 10px 0;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 10px;
                margin: 4px;
                color: #ffffff;
                cursor: pointer;
            }
            </style>
    </head>

    <body>
        &nbsp; <a href='main.jsp'> <img src='logo.PNG'> </a> 
        <center> <font size='6'><b> 로그인 </b></font> <br><br>
        <hr>
        <br><br><br><br>
        
        <!-- 아이디와 비밀번호를 입력받음 -->
        <table border='1' bordercolor='#BDBDBD' width='500' height='180' cellspacing='0' >
        <tr><td align='center' valign='middle'>
            <form  action="Login" method="post"> <!--db와 연결-->
              <input type="number" name="id" placeholder="학번 입력"><p> <!--db에 저장된 id-->
              <input type="password" name="pw" placeholder="비밀번호 입력"><p> <!--db에 저장된 pw-->
              <input type="submit" value="로그인">
            </form>
        </td></tr>
        </table>
        
        <!-- DB에 저장된 아이디와 비밀번호가 같으면 다음 창으로 이동 아니면 오류메시지 출력-->

        </center>

    </body>


</html>