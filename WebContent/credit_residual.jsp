<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 int kicho = (int)request.getAttribute("kicho");
 int hacksimeng = (int)request.getAttribute("hacksimeng");
 int kidok = (int)request.getAttribute("kidok");
 int seke = (int)request.getAttribute("seke");
int korean = (int)request.getAttribute("korean");
int jeongbo = (int)request.getAttribute("jeongbo");
int mentor = (int)request.getAttribute("mentor");
int select = (int)request.getAttribute("select");
int sum = (int)request.getAttribute("sum");
%>

<!DOCTYPE html>
<html>
    <head>
        <title> 남은 학점 </title>
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
        &nbsp; <a href='menu.jsp'> <img src='./logo.PNG'> </a> <!--홈으로 이동-->
        <center> <font size='6'><b> 남은 학점 </b></font> <br><br>

        <table border = '1' width = '100%' height ='1200' bordercolor='#BDBDBD' cellspacing='0'>
            <tr>
                <td bgcolor = 'white' valign='top' width = '15%' ><!--메뉴선택 테이블-->
                    <table border='0' align='center' height='70' cellspacing='0'>
                        <tr></tr>&nbsp;
                        <tr></tr>&nbsp;
                        <tr align='center'>
                            <td width='150'><button class='btn2'><a onclick="window.location.href='credit_input.jsp'"><b>학점입력</b></a></button></td>
                        </tr>
                        <tr></tr>&nbsp;
                        <tr align='center'>
                            <td width='150'><form action="gradeCheck", method="get">
                    		<input type="submit" class='btn2' value="학점관리" >
                    		</form></td> 
                        </tr>
                        <tr></tr>&nbsp;
                        <tr align='center'>
                            <td width='150'><button id='btn1'><a onclick="window.location.href='credit_residual.jsp'"><b>남은학점</b></a></button></td><!--현재 페이지-->
                        </tr>
                        <tr></tr>&nbsp;   
                        <tr align='center'>
                            <td width='150'><form action="recommend" method="get">
           	 				<input type="submit" class='btn2' value="과목 추천" >
            				</form></td><!--과목추천페이지로 이동-->
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
                </td><!--메뉴선택 테이블-->
                
                <td  bgcolor = 'white' valign='top' width = '85%'><!--중앙 화면 테이블-->
                    <br><br><br><br>
                    <center>
                    <table border = '1'  width = 500 height ='100' bordercolor='#BDBDBD' cellspacing='0'>
                        <tr align='center' >
                            <td bgcolor='#acacac'><b>구분</b></td>
                            <td bgcolor='#acacac'><b>남은학점</b></td>
                        </tr>
                        <tr align='center' >
                            <td>기초교과군</td>
                            <td><%=kicho%></td> <!--DB에서 전공 이수학점 가져오기-->
                        </tr>
                        <tr align='center'>
                            <td>핵심교과군</td>
                            <td rowspan = '3'><%=hacksimeng%></td> <!--DB에서 교필 이수학점 가져오기-->
                        </tr>
                        <tr align='center' >
                            <td>심화교과군</td>
                        </tr>
                        <tr align='center' >
                            <td>응용교과군</td>
                        </tr>
                        <tr align='center' >
                            <td>기독교</td>
                            <td><%=kidok%></td> <!--DB에서 전공 이수학점 가져오기-->
                        </tr>
                        <tr align='center' >
                            <td>세계화</td>
                            <td><%=seke%></td> <!--DB에서 전공 이수학점 가져오기-->
                        </tr>
                        <tr align='center' >
                            <td>정보화</td>
                            <td><%=jeongbo%></td> <!--DB에서 전공 이수학점 가져오기-->
                        </tr>
                        <tr align='center' >
                            <td>국어</td>
                            <td><%=korean%></td> <!--DB에서 전공 이수학점 가져오기-->
                        </tr>
                        <tr align='center' >
                            <td>멘토링</td>
                            <td><%=mentor%></td> <!--DB에서 전공 이수학점 가져오기-->
                        </tr>
                        <tr align='center' >
                            <td>교양선택</td>
                            <td><%=select%></td> <!--DB에서 전공 이수학점 가져오기-->
                        </tr>
                        <tr align='center' >
                            <td bgcolor='#acacac'><b>총 남은 학점</b></td>
                            <td><%=sum%></td>
                        </tr>
                    </table>   <!--중앙 화면 테이블-->
                    </center>
                </td>
            </tr>
        </table>
</center>

</body>
</html>