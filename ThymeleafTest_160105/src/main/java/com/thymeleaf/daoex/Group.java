package com.thymeleaf.daoex;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "project_groups")
// @IdClass(GroupID.class)
public class Group implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;

	private String role;

	@ManyToOne @JoinColumn(name = "person_id")
	private Person person;
	
	@ManyToOne @JoinColumn(name="project_id")
	private Project project;

	public Group() {
	}

	public Group(Person person, Project project, String role) {
		this.person = person;
		this.project = project;
		this.role = role;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
