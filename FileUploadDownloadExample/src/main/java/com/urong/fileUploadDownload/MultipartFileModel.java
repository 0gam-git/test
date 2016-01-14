package com.urong.fileUploadDownload;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileModel {

	private String name;
	private MultipartFile file;
	
	public MultipartFileModel(String name, MultipartFile file) {
		this.name = name;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFileModel() {
		// TODO Auto-generated constructor stub
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
