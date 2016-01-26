package com.thymeleaf.daoex;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "job_info")
public class JobInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;

	private String jobName;
	private String jobDescription;

	@OneToMany(mappedBy = "jobInfo", cascade = CascadeType.ALL)
	private List<JobDefine> jobDefines;

	public JobInfo() {
	}

	public JobInfo(String job_name, String jobDescription) {
		this.jobName = job_name;
		this.jobDescription = jobDescription;
		this.jobDefines = new ArrayList<JobDefine>();
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public List<JobDefine> getJobDefines() {
		return jobDefines;
	}

	public void setJobDefines(List<JobDefine> jobDefines) {
		this.jobDefines = jobDefines;
	}

	@Override
	public String toString() {
		return "{ \"idx\":\"" + idx + "\", \"jobName\":\"" + jobName + "\", \"jobDescription\":\"" + jobDescription
				+ "\"}";
	}

}
