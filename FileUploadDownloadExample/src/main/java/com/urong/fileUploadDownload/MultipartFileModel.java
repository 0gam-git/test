package com.urong.fileUploadDownload;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileModel {

	private String description;
	private MultipartFile file;

	public MultipartFileModel() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFileModel(String description, MultipartFile file) {
		this.description = description;
		this.file = file;
	}
	
}
