<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="jquery/jquery-1.11.1.min.js"></script>
<script src="jquery/jquery-ui.min.js"></script>
<script src="js/function.js"></script>
<script src="js/upload.js"></script>
<script src="croppie/croppie.js" charset="UTF-8"></script>
<script src="croppie/croppie.min.js" charset="UTF-8"></script>
<script src="croppie/prism.js" charset="UTF-8"></script>
<link href="jquery/jquery-ui.min.css" rel="stylesheet" />
<link href="jquery/jquery-ui.theme.min.css" rel="stylesheet" />
<link href="croppie/croppie.css" rel="stylesheet" />


<title>Insert title here</title>
<style type="text/css">
#spinner {
	display: none;
}

.noTitle .ui-dialog-titlebar {
	display: none
}
</style>
</head>
<body>
	<!-- 	<form id="UploadForm" enctype="multipart/form-data" method="POST">
		<input type="file" id="file" name="file"> <input type="submit"
			value="Upload">
	</form>
	<progress value="0" max="100" color="red"></progress>
	 -->
	<h5>&lt;파일 업로드&gt;</h5>
	<form id="UploadForm" method="POST" enctype="multipart/form-data">
		<label>description : </label> <input type="text" name="description"
			id="description" /> <label>file : </label> <input type="file"
			name="file" id="file" /> <input type="button" value="upload"
			id="uploadButton" />
	</form>
	<progress value="0" max="100"></progress>
	<br />
	<br />
	<form id="UploadForm2" method="POST" enctype="multipart/form-data">
		<label>description : </label> <input type="text" name="description"
			id="description" /> <label>file : </label> <input type="file"
			name="file" id="file" /> <input type="button" value="upload"
			id="uploadButton2" />
	</form>

	<img id="spinner" src="img/hack.gif" style="width: 100px; "/>
	<div id="upload-demo"></div>
	<div>
		<input type="button" id="resultButton" value="result" name="result" />
	</div>

	<div class="resultDialog" style="display: none;">
		<img src="" style="width: 100%;" id="dialogImg" />
		<input type="button" value="confirm" id="confirmButton" />
	</div>

	<script type="text/javascript" charset="UTF-8">
		$("#upload-demo").hide();
		$('#upload-demo').croppie({
			viewport : {
				width : 200,
				height : 200
			},
			boundary : {
				width : 300,
				height : 300
			}
		});
	</script>

</body>
</html>