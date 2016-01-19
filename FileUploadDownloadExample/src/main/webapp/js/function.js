$(document).ready(function() {
	var upload = new Upload();
	
	$("#uploadButton").click(function(e){
		upload.fileUpload();
	});
	
	$("#uploadButton2").click(function(e){
		upload.fileUpload2();
	});
	
});
