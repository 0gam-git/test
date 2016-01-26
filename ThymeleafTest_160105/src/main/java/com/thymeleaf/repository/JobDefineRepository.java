package com.thymeleaf.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thymeleaf.daoex.JobDefine;
import com.thymeleaf.daoex.JobInfo;
import com.thymeleaf.daoex.Person;

public interface JobDefineRepository extends PagingAndSortingRepository<JobDefine, Integer>{

//	@Query("select g" + " from project_groups g" + " join g.person p"
//			+ " where p = :person)")
//	List<JobDefine> joinByPerson(@Param("person") Person person);
	
	//select p.*, j.* from person p, job_info j where p.idx = j.person_id
	
	List<JobDefine> findByPerson(Person person);
	List<JobDefine> findByJobInfo(JobInfo jobInfo);
}
