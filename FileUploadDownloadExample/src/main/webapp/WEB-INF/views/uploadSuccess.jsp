<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./jquery/jquery-1.11.1.min.js"></script>
<script src="./jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="./js/fuction.js"></script>
<script src="./js/upload.js"></script>
<title>Insert title here</title>
</head>
<body>

<h2>Spring MVC file upload example</h2>

FileName : "<strong> ${fileName} </strong>" - Simple Uploaded Successful.

<br>
<table>
	<td><a href="downolad.do?fileName=${fileName}">${fileName}<a></td>
</table>

</body>
</html>