package com.thymeleaf.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.thymeleaf.daoex.Group;
import com.thymeleaf.daoex.Person;
import com.thymeleaf.daoex.Project;

import java.util.List;

public interface GroupRepository extends
		PagingAndSortingRepository<Group, Integer> {

	@Query("select g" + " from project_groups g" + " join g.person p"
			+ " where p = :person)")
	List<Group> joinByPerson(@Param("person") Person person);

	List<Group> findByPerson(Person person);

	List<Group> findByProject(Project project);

}
