<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> 학생 정보 수정 </title>
        <link rel="stylesheet" type="text/css" href="reset.css" />
        <style>
            #btn1 {
                width:100px;
                border: 1px;
                background-color:#418BE0;
                padding: 12px 0;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 15px;
                margin: 4px;
                color: #000000;
                cursor: pointer;
            }
            .btn2 {
                width:100px;
                border: 1px;
                background-color:#6FAFFA;
                padding: 12px 0;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 15px;
                margin: 4px;
                color: #ffffff;
                cursor: pointer;
            }
            #btn2 {
                width:100px;
                border: 1px;
                background-color:#6FAFFA;
                padding: 12px 0;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 15px;
                margin: 4px;
                color: #ffffff;
                cursor: pointer;
            }
            #btn3 {
            width:100px;
            border: 1px;
            background-color:#c5c5c5;
            padding: 12px 0;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 4px;
            color: #000000;
            cursor: pointer;
            }
            </style>
    </head>

    <body>
        &nbsp; <a href='menu.jsp'> <img src='./logo.PNG'> </a> <!--메뉴로 이동-->
        <center> <font size='6'><b> 학생 정보 수정 </b></font> <br><br>
            <table border = '1' width = '100%' height ='1200' bordercolor='#BDBDBD' cellspacing='0'> <!--전체 테이블-->
                <tr>
                    <td bgcolor = 'white' valign='top' width = '15%' ><!--메뉴선택 테이블-->
                        <table border='0' align='center' height='70' cellspacing='0'>
                            <tr></tr>&nbsp;
                            <tr></tr>&nbsp;
                            <tr align='center'>
                                <td width='150'>
                                <form action="StudentInfo", method="get">
                    			<input type="submit" id='btn2' value="학생정보 확인" >
                    			</form></td>
                            </tr>
                            <tr></tr>&nbsp;
                            <tr align='center'>
                                <td width='150'><button id='btn1'><a onclick="window.location.href='stu_info_change.jsp'"><b>학생정보 수정</b></a></button></td> <!--현재 페이지-->
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                            </tr>
                            <tr align='center'>
                                <td width='150'>
                                <form action="Logout", method="get">
                    			<input type="submit" id='btn3' value="로그아웃" >
                    			</form></button></td> <!--관리자 계정으로 이동-->
                            </tr>
                        </table>
                    </td ><!--메뉴선택 테이블-->

                    <td bgcolor = 'white' valign='top' width = '85%'><center> <br><br> <!--중앙 화면 테이블--> 
                        <form method="post" action="Update"><!--DB를 수정하는 폼-->
                            <table border = '1' width = '250' height ='400' bordercolor='#BDBDBD' cellspacing='0'>
                            <tr><td bgcolor = 'white' valign='top' ><!--테두리-->
                                <table border='0' align='center' width = '250' height='400' cellspacing='0'>
                                    <tr>
                                        <td>&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;&nbsp;<b>학부 (예.컴퓨터공학부)</b></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;<input type="text" name="department"></td> <!-- 학생 학부 DB에서 가져오기-->
                                    </tr>
                                    <tr>
                                        <td>&nbsp;&nbsp;<b>학과 (예.소프트웨어학과)</b></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;<input type="text" name="major"></td> <!-- 학생 학과 DB에서 가져오기-->
                                    </tr>
                                    <tr>
                                        <td>&nbsp;&nbsp;<b>학년</b></td>
                                    </tr>
                                    <tr>
                                        <td>&nbsp;
                                            <input type="radio" name="schoolYear" value="1"> 1학년 <!--db연동-->
                                            <input type="radio" name="schoolYear" value="2"> 2학년<br> <!--db연동-->
                                            &nbsp;<input type="radio" name="schoolYear" value="3"> 3학년 <!--db연동-->
                                            <input type="radio" name="schoolYear" value="4"> 4학년 <!--db연동-->
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align='right'><input type=submit value="수정하기">&nbsp;</td><!--DB 수정-->
                                    </tr>
                                </table>
                            </td></tr>
                            </table><!--테두리-->
                        </form> <!--DB를 수정하는 폼-->
                    </center>
                </td> </tr><!--중앙 화면 테이블-->
            </table> <!--전체 테이블-->
                    
        </center>
    </body>
</html>