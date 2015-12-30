<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript" src="jquery.autocomplete.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var data = [ {
		company : 'yg entertainment'
	}, {
		company : 'jyp entertainment'
	}, {
		company : 'antena entertainment'
	}, {
		company : 'sm entertainment'
	}, {
		company : 'start kingdom entertainment'
	}, {
		company : '라쿠시 엔터테인먼트3'
	}, {
		company : '라쿠시 엔터테인먼트3'
	}, {
		company : '라쿠시 엔터테인먼트3'
	}, {
		company : '라쿠시 엔터테인먼트3'
	} ];

	$(document).ready(function() {
		$("#company").autocomplete(data, {
			matchContains : true,
			minChars : 0,
			width : 172,
			max : 10,
			multiple : false,
			scroll : true,
			scrollHeight : 300,
			formatItem : function(item) {
				return item.company;
			}
		})
	});
</script>
</head>
<body>

	업체명 :
	<input type="text" id="company" autocomplete="on">
</body>
</html>