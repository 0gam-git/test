package com.thymeleaf.model;

import java.io.Serializable;

public class Project11 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String projectName;
	private String projectDecription;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDecription() {
		return projectDecription;
	}
	public void setProjectDecription(String projectDecription) {
		this.projectDecription = projectDecription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Project11() {
	}
	
	public Project11(String projectName, String projectDecription) {
		this.projectName = projectName;
		this.projectDecription = projectDecription;
	}
}
