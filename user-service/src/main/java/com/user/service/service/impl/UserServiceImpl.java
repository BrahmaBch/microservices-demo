package com.user.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.service.dao.UserDAO;
import com.user.service.dto.Result;
import com.user.service.entity.UserEnity;
import com.user.service.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Result saveUser(UserEnity user) {
        UserEnity user1 = userDAO.save(user);
        Result result = new Result();
        result.setData(user1);
        result.setStatusCode(HttpStatus.OK.value());
        result.setSuccesMessage("User saved successfully");
        return result;
    }

	@Override
	public Result getByUserId(Long userId) {
		 UserEnity user1 = userDAO.getByUserId(userId);
	        Result result = new Result();
	        result.setData(user1);
	        result.setStatusCode(HttpStatus.OK.value());
	        result.setSuccesMessage("User saved successfully");
        return result;
	}
}
