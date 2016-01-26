package com.thymeleaf.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.thymeleaf.daoex.Project;


public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer>{

}
