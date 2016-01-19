var Upload = function(name, description) {
	this.name = name;
	this.description = description;
};

Upload.prototype.fileUpload = function() {
	var form = new FormData(document.getElementById('UploadForm'));

	$.ajax({
		url : "fileUpload.do",
		type : 'POST',
		xhr : function() {
			myXhr = $.ajaxSettings.xhr();
			if (myXhr.upload) {
				myXhr.upload.addEventListener('progress', function(evt) {
					if (evt.lengthComputable) {
						$('progress').attr({
							value : evt.loaded,
							max : evt.total
						});
					}
				}, false);
			}
			return myXhr;
		},
		data : form,
		dataType : 'text',
		processData : false,
		contentType : false,
		success : function(response) {
			$('progress').attr({
				value : 100,
				max : 100
			});
			/* window.location.href = response; */

		},
		error : function(jqXHR) {
			console.log('error');
		}
	});
};

Upload.prototype.fileUpload2 = function() {
	var form = new FormData(document.getElementById('UploadForm2'));

	$.ajax({
		url : "fileUpload.do",
		type : 'POST',
		data : form,
		dataType : 'text',
		processData : false,
		contentType : false,
		beforeSend : function() {
			$("#spinner").show();
		},
		success : function(response) {
			$("#spinner").hide();
		},
		error : function(jqXHR) {
			console.log('error');
		}
	});
};
