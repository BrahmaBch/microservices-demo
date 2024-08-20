package com.user.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.entity.UserEnity;


@Repository
public interface UserDAO extends JpaRepository<UserEnity, Long> {
	
	UserEnity getByUserId(Long userId);

}
