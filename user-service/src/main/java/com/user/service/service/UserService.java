package com.user.service.service;

import com.user.service.dto.Result;
import com.user.service.entity.UserEnity;

public interface UserService {

    public Result saveUser(UserEnity user);

	public Result getByUserId(Long userId);
}
