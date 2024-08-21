package com.user.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.entity.UserEntity;


@Repository
public interface UserDAO extends JpaRepository<UserEntity, Long> {
	
	UserEntity getByUserId(Long userId);

}
