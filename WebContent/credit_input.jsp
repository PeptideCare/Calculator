<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> 학점 입력 </title>
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
        <center> <font size='6'><b> 학점 입력 </b></font> <br><br>

        <table border = '1' width = '100%' height ='1200' bordercolor='#BDBDBD' cellspacing='0'> <!--전체 테이블-->
            <tr>
                <td bgcolor = 'white' valign='top' width = '15%' ><!--메뉴선택 테이블-->
                    <table border='0' align='center' height='70' cellspacing='0'>
                        <tr></tr>&nbsp;
                        <tr></tr>&nbsp;
                        <tr align='center'>
                            <td width='150'><button id='btn1'><a onclick="window.location.href='credit_input.jsp'"><b>학점입력</b></a></button></td><!--현재 페이지-->
                        </tr>
                        <tr></tr>&nbsp;
                        <tr align='center'>
                            <td width='150'>
                            <form action="gradeCheck", method="get">
                    		<input type="submit" class='btn2' value="학점관리" >
                    		</form></td> 
                        </tr>
                        <tr></tr>&nbsp;
                        <tr align='center'>
                            <td width='150'><form action="subCheck", method="get">
                    		<input type="submit" class='btn2' value="남은학점" >
                    		</form></td>
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
                    </table >
                </td ><!--메뉴선택 테이블-->


                <td  bgcolor = 'white' valign='top' width = '85%'><center> <br><br><br><br><!--중앙 화면 테이블-->
                    <table border = '0' width = '250' height ='130' cellspacing='0'> <!--테두리-->
                        <tr><td bgcolor = 'white' valign='top' >

                            <form method="post" action="Addsubject"> <!--db와 연결, 학점 입력 테이블-->
                            <table border = '1' width = '250' height ='100' bordercolor='#BDBDBD' cellspacing='0'>
                                <tr>
                                    <td bgcolor='#acacac'>과목명</td>
                                    <td bgcolor='#acacac'>과목코드<br></td>
                                    <td bgcolor='#acacac'>이&nbsp;수&nbsp;구&nbsp;분<br></td>
                                    <td bgcolor='#acacac'>학&nbsp;&nbsp;점</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="name"><br><br></td>
                                    <td><input type="number" name="code"><br><br></td>
                                    <td><select name = "classification"><!--이수구분-->
                                        <option>기초교과군</option>
                                        <option>핵심교과군</option>
                                        <option>심화교과군</option>
                                        <option>응용교과군</option>
                                        <option>기독교인성</option>
                                        <option>세계화</option>
                                        <option>국어</option>
                                        <option>정보화</option>
                                        <option>멘토링</option>
                                        <option>교양선택</option>
                                    </select></td><!--이수구분-->
                                    <td><select name = "credit"><!--학점-->
                                        <option>0</option>
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                    </select></td><!--학점-->
                                </tr>
                            </table><br>
                            <center><input type=submit value="입력"></center>
                            </form> <!--db와 연결, 학점 입력 테이블-->

                        </td></tr>
                    </table> <!--테두리-->
                </center></td><!--중앙 화면 테이블-->
            </tr>
        </table> <!--전체 테이블-->
</center>

</body>
</html>