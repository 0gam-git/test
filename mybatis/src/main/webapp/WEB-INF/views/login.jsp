<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/screen.css" />
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript" src="jquery.validate.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<h1 style="text-align: center">로그인</h1>

		<form action="confirmLogin.do"  method="POST">
		<table id="login-box">
		<tr>
		<td>아이디</td>
		<td>
	      	<input type="text" name="id" id="id" autofocus/><br/>
		</td>
		</tr>
		<tr>
		<td>비밀번호</td>
		<td>
   			<input type="password" name="password" id="password" /><br/>
		</td>
		</tr>
		<!-- <div style="text-align: center"> -->
		<tr>
		<td>
			<input type="submit" value="로그인"  style="width:100px; margin-top: 30px; "/>
		</td>
		
		<td>
			<input type="button" onclick="location.href='join.do'" value="회원가입" 
			style="margin-top: 30px; margin-left: 70px; width:100px;"/>
		</td>
		</tr>
		</table>
		</form>
	<c:if test="${not empty faild}">
	<script type="text/javascript">
		 alert("아이디 또는 비밀번호가 틀렸습니다.");
		 location.href = "login.do"
	</script>
	</c:if>
	
	<c:if test="${not empty logout}">
	<script type="text/javascript">
		 alert("로그아웃 하셨습니다.");
		 location.href = "login.do"
	</script>
	</c:if>

	<script type="text/javascript">
		$(function() {
			$("form").validate({
				//validation이 끝난 이후의 submit 직전 추가 작업할 부분
				debug: false,
		        onfocusout: false,
		        
				//규칙
				rules : {
					id : {
						required : true,
						minlength : 5,
					},
					password : {
						required : true,
						minlength : 8
					}
				},
				//규칙체크 실패시 출력될 메시지
				messages : {
					id : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						minlength : " <font color='red'>최소 {0}글자이상이어야 합니다.</font>",
						remote : " 존재하는 아이디입니다."
					},
					password : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						minlength : " <font color='red'>최소 {0}글자이상이어야 합니다.</font>"
					}
				}
			});
		})
	</script>
</body>
</html>