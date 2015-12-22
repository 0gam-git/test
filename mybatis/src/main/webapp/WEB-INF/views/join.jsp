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
<title>회원가입</title>
</head>

<body>
	<h1 style="text-align: center">회원가입</h1>

	<form action="joinMember.do" method="POST" name="fm">
		<table id="join-box">
			<tr>
			<td>아이디</td>
			<td>
			<input type="text" name="id" id="id" onkeydown="idcheck();" autofocus />
			<span id = "idcheckLayer"></span></td>
			</tr>
			<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name="repassword" id="repassword" /></td>
			</tr>
			<tr>
			<td>나이</td>
			<td><input type="text" name="age" id="age" /></td>
			</tr>
			<tr>
			<td>이름</td>
			<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
			<td>이메일</td>
			<td><input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
			<td>홈페이지</td>
			<td><input type="text" name="homepage" id="homepage" /></td>
			</tr>
			<tr>
			</tr>
			<tr>
			<td>
			<input type="submit" value="회원가입" style="margin-top: 15px; width:100px;" />
			</td>
			</tr>
		</table>
	</form>
	
	<c:if test="${empty flagCheckId}">
	<script type="text/javascript">
	 	alert(flagCheckId+"는 사용가능한 아이디 입니다.");
	</script>
	</c:if>
	
	<c:if test="${not empty flagCheckId}">
	<script type="text/javascript">
	 	alert(flagCheckId+"는 현재 사용 중 입니다.");
	</script>
	</c:if>
	
	<script type="text/javascript">
	var xhr;
	function createXhr(){
	    if(window.ActiveXObject){   // IE 이전버전
	        xhr = new ActiveXObject("Microsoft.XMLHTTP");
	    }else{
	        xhr = new XMLHttpRequest();
	    }
	}
	 
	function idcheck(){
	    var id = document.getElementById("id").value;
	    var queryString ="id=" + id;
	    /* var idLength = parseInt(queryString);
	    if(idLength.length() > 5){ */
	    
	        // 1. XMLHttpReqeust 객체 생성
	        createXhr();
	        // 2. 이벤트 핸들러 등록
	        xhr.onreadystatechange = callback;  // callback 함수를 등록
	        // 3. open()를 통해 요청관련 설정을 설정
	        xhr.open("POST", "check_id.do", true);
	        // 4. Header에 contentType 지정 - post
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	        // 5. send()를 통해 요청
	        xhr.send(queryString);  // 요청 쿼리를 보내준다.
	    /*  }*/
	}
	
	function callback(){
	    if(xhr.readyState==4){      // 응답을 다 받은 경우
	        if(xhr.status == 200){  // 응답코드가 200인 경우 - 정상인 경우
	            var resTxt = xhr.responseText;  // 서버가 보낸 응답 text
	            
	            document.getElementById("idcheckLayer").innerHTML = resTxt;         
	        }else{
	           // alert("요청 처리가 정상적으로 되지 않았습니다.\n"+xhr.status);
	        }
	    }
	}

		$(function() {
			$("form").validate({
				//validation이 끝난 이후의 submit 직전 추가 작업할 부분
				debug : false,
				onfocusout : false,
				
				//규칙
				rules : {
					id : {
						required : true,
						minlength : 5,
					},
					password : {
						required : true,
						minlength : 8
					},
					repassword : {
						required : true,
						minlength : 8,
						equalTo : password
					},
					name : {
						required : true,
						minlength : 2
					},
					age : {
						required : true,
						digits : true
					},
					email : {
						required : true,
						minlength : 5,
						email : true
					},
					homepage : {
						url : true
					}
				},
				//규칙체크 실패시 출력될 메시지
				messages : {
					id : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						minlength : " <font color='red'>최소 {0}글자 이상이어야 합니다.</font>",
					},
					password : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						minlength : " <font color='red'>최소 {0}글자 이상이어야 합니다.</font>",
					},
					repassword : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						minlength : " <font color='red'>최소 {0}글자 이상이어야 합니다.</font>",
						equalTo : " <font color='red'>비밀번호가 일치하지 않습니다.</font>"
					},
					name : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						minlength : " <font color='red'>최소 {0}글자 이상이어야 합니다.</font>",
					},
					age : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						digits : " <font color='red'>숫자만입력하세요.</font>"
					},
					email : {
						required : " <font color='red'>필수로 입력하세요.</font>",
						minlength : " <font color='red'>최소 {0}글자 이상이어야 합니다.</font>",
						email : " <font color='red'>메일규칙에 어긋납니다.</font>"
					},
					homepage : {
						url : " <font color='red'>정상적인 URL이 아닙니다.</font>"
					}
				}
			});
		})
	</script>
</body>
</html>