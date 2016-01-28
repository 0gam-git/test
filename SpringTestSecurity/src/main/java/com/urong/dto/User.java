package com.urong.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user_1")
public class User {

	@Id
	private String id;
	
	private String password;

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
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
	
	@Override
	public String toString() {
		return "{ \"idx\":\"" + id + "\", \"name\":\"" + password + "/ }";
	}

}
