$(document).ready(function() {
	var upload = new Upload();

	$("#uploadButton").click(function(e) {
		upload.fileUpload();
	});

	$("#uploadButton2").click(function(e) {
		upload.fileUpload2();
	});

	$("#resultButton").click(function(e) {
		upload.result();
	});

	$("#confirmButton").click(function(e) {
		upload.dataUpload();
	});

});
