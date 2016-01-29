package com.urong.dto;

public class MybatisAuthority {

	private String userId;
	private String authority;

	public MybatisAuthority() {
		// TODO Auto-generated constructor stub
	}

	public MybatisAuthority(String userId, String authority) {
		this.userId = userId;
		this.authority = authority;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
