package com.thymeleaf.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thymeleaf.daoex.JobInfo;

public interface JobInfoRepository extends PagingAndSortingRepository<JobInfo, Integer> {

	
}
