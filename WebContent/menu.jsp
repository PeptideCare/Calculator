<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> 메뉴 </title>
        <link rel="stylesheet" type="text/css" href="reset.css" />
        <style>
            #btn1 {
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
            .btn2 {
            width:100px;
            border: 1px;
            background-color:#418BE0;
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
            background-color:#418BE0;
            padding: 12px 0;    
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
        &nbsp; <a href='menu.jsp'><img src='./logo.PNG'> </a>
        <center> <font size='6'><b> 메뉴 </b></font> <br><br><hr><br><br>
            <table border='0' align='center' height='70' cellspacing='0'>
    
                <tr align='center'>
                    <td width='150'>
                    <form action="StudentInfo", method="get">
                    <input type="submit" id='btn2' value="학생계정" >
                    </form></td>
                </tr>
                <tr align='center'>
                    <td width='150'><form action="gradeCheck", method="get">
                    <input type="submit" id='btn2' value="학점관리" >
                    </form></td>
                </tr>

                <tr align='center'>
                    <td width='150'><button class='btn2'><a onclick="window.location.href='EC.jsp'"><b>관리자계정</b></a></button></td> <!--관리자 계정으로 이동-->
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
                    <input type="submit" id='btn1' value="로그아웃" >
                    </form>
                </tr>
            </table>



    </body>
</html>