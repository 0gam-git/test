var Upload = function(name, description) {
	this.name = name;
	this.description = description;
};

var imgViewer = function() {
	$('#upload-demo').croppie({
		viewport : {
			width : 200,
			height : 200
		},
		boundary : {
			width : 300,
			height : 300
		}
	})
};
// progress bar
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

		},
		error : function(jqXHR) {
			console.log('error');
		}
	});
};

// spinner
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
			$('#upload-demo').show();

			$('#upload-demo').croppie('bind', {
				url : response,
			// points : [ 77, 469, 280, 739 ]
			});
		},
		error : function(jqXHR) {
			console.log('error');
		}
	});
};

Upload.prototype.result = function() {
	$('#upload-demo').croppie('result', {
		type : 'canvas',
		size : 'original'
	}).then(function(resp) {
		popupResult({
			src : resp
		});
	});

	// result({ type: 'canvas|html', size: 'viewport|originall' }
};

function popupResult(result) {
	var html;

	if (result.src) {
		html = result.src;
	}

	$(".resultDialog").dialog({
		modal : true,
		dialogClass : 'noTitle',
		width : 500,
		height : 550
	});
	$(".resultDialog img").attr("src", html);

	$('.ui-widget-overlay').click(function() {
		$(".resultDialog").dialog("close");
	});
}

Upload.prototype.dataUpload = function() {
	
	var url = "profileUpload.do";
	var image = $('#dialogImg').attr('src');
	var base64ImageContent = image.replace('data:image/png;base64,', "");
	var blob = base64ToBlob(base64ImageContent, 'image/png');
	var formData = new FormData();
	formData.append('picture', blob);

	$.ajax({
		url : url,
		type : "POST",
		cache : false,
		contentType : false,
		processData : false,
		data : formData,
	}).done(function(e) {
		alert('done!');
	})
};

function base64ToBlob(base64, mime) {
	mime = mime || '';
	var sliceSize = 1024;
	var byteChars = window.atob(base64);
	var byteArrays = [];

	for (var offset = 0, len = byteChars.length; offset < len; offset += sliceSize) {
		var slice = byteChars.slice(offset, offset + sliceSize);

		var byteNumbers = new Array(slice.length);
		for (var i = 0; i < slice.length; i++) {
			byteNumbers[i] = slice.charCodeAt(i);
		}

		var byteArray = new Uint8Array(byteNumbers);

		byteArrays.push(byteArray);
	}

	return new Blob(byteArrays, {
		type : mime
	});
}
