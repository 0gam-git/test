package com.urong.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.urong.dto.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {


}
