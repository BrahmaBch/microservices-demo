package com.user.service.service;

import com.user.service.VO.ResponseTemplate;
import com.user.service.dto.Result;
import com.user.service.entity.UserEntity;
import com.user.service.exception.ResourceNotFoundException;

public interface UserService {

    public Result saveUser(UserEntity user);

	public Result getByUserId(Long userId);

    ResponseTemplate getByUserWithDepartment(Long userId) throws ResourceNotFoundException;
}
