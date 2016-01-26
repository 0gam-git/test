package com.thymeleaf.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thymeleaf.daoex.Person;

import java.lang.String;
import java.util.List;

public interface PersonRepository extends
		PagingAndSortingRepository<Person, Integer> {

	List<Person> findByName(String name);

	List<Person> findByEmail(String email);

}
