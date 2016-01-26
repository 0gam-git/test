package com.thymeleaf.daoex;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "person")
public class Person {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;

	private String name;
	private String email;
	private String password;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Group> groups;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<JobDefine> jobDefines;

	public Person() {
	}

	public Person(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.jobDefines = new ArrayList<JobDefine>();
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Group> getGroups() {
		return groups;
	}

	public List<JobDefine> getJobDefines() {
		return jobDefines;
	}
	
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public void setJobDefines(List<JobDefine> jobDefines) {
		this.jobDefines = jobDefines;
	}

	@Override
	public String toString() {
		return "{ \"idx\":\"" + idx + "\", \"name\":\"" + name + "\", \"email\":\"" + email + "\"}";
	}

}
