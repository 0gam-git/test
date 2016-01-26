package com.thymeleaf.daoex;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="job_define")
public class JobDefine implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;
	
	@ManyToOne @JoinColumn(name="person_id") //조인컬럼 생략 시 기본정책 = "person_id"로 자동 생성
	private Person person;
	
	@ManyToOne @JoinColumn(name="jobInfo_id") //"필드명"+"_"+기본키 컬럼명 = "jobInfo"+"_"+"Id"
	private JobInfo jobInfo;
	
	public JobDefine() {}

	
	public int getIdx() {
		return idx;
	}
	
	public JobDefine(Person person, JobInfo jobInfo) {
		this.person = person;
		this.jobInfo = jobInfo;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Person getPerson() {
		return person;
	}
	
	public JobInfo getjobInfo() {
		return jobInfo;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public void setjobInfo(JobInfo jobInfo) {
		this.jobInfo = jobInfo;
	}

}
