package com.user.service.service.impl;

import com.user.service.VO.Department;
import com.user.service.VO.DepartmentResponse;
import com.user.service.VO.ResponseTemplate;
import com.user.service.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user.service.dao.UserDAO;
import com.user.service.dto.Result;
import com.user.service.entity.UserEntity;
import com.user.service.service.UserService;
import org.springframework.web.client.RestTemplate;


@Service @Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public Result saveUser(UserEntity user) {
        UserEntity user1 = userDAO.save(user);
        Result result = new Result();
        result.setData(user1);
        result.setStatusCode(HttpStatus.OK.value());
        result.setSuccesMessage("User saved successfully");
        return result;
    }

	@Override
	public Result getByUserId(Long userId) {
		 UserEntity user1 = userDAO.getByUserId(userId);
	        Result result = new Result();
	        result.setData(user1);
	        result.setStatusCode(HttpStatus.OK.value());
	        result.setSuccesMessage("User get successfully");
        return result;
	}

    @Override
    public ResponseTemplate getByUserWithDepartment(Long userId) throws ResourceNotFoundException {
        ResponseTemplate responseTemplate = new ResponseTemplate();

        // Fetch the user by userId
        UserEntity user = userDAO.getByUserId(userId);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
        // Fetch the department using RestTemplate
        Department department = null;
        try {
            DepartmentResponse response = restTemplate.getForObject(
                    "http://DEPARTMENT-SERVICE/department/get-department/"
                    + user.getDepartmentId(),
                    DepartmentResponse.class
            );
            department = response.getData();
        } catch (Exception e) {
            log.error("Error fetching department: " + e.getMessage());
        }

        responseTemplate.setUserEnity(user);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }
}
