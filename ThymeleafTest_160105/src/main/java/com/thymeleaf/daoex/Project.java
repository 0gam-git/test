package com.thymeleaf.daoex;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;

	private String name;
	private String description;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Group> groups;

	public Project() {
	}

	public Project(String name, String description) {
		this.name = name;
		this.description = description;
		this.groups = new ArrayList<Group>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "{ \"idx\" : \"" + idx + "\", \"name\" : \"" + name + "\" }";
	}
}
