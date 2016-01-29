package com.urong.dto;

public class MybatisUser {

	private String id;
	private String password;
	private boolean enabled;

	public MybatisUser() {
		// TODO Auto-generated constructor stub
	}

	public MybatisUser(String id, String password, boolean enabled) {
		this.id = id;
		this.password = password;
		this.enabled = enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
