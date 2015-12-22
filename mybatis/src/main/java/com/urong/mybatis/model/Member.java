package com.urong.mybatis.model;

public class Member {

	private String id;
	private String password;
	private String repassword;
	private int age;
	private String name;
	private String email;
	private String homepage;
	
	public Member() {}

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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public Member(String id, String password, String repassword, int age, String name, String email, String homepage) {
		this.id = id;
		this.password = password;
		this.repassword = repassword;
		this.age = age;
		this.name = name;
		this.email = email;
		this.homepage = homepage;
	}
}
