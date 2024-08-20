package com.user.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.user.service.dto.Result;
import com.user.service.entity.UserEnity;
import com.user.service.service.UserService;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getString")
	public String getString() {
		return "getString method called";
	}

	@PostMapping("/save-user")
	public ResponseEntity<Result> saveUser(@RequestBody UserEnity user) {
		log.info("<<<<<<<<<<<  start saveUser() ");
		try {
			if (user.getUserFirstName() != null || !user.getUserFirstName().isEmpty()) {
				Result result = userService.saveUser(user);
				log.info(">>>>>>>>> end saveUser() ");
				return new ResponseEntity<>(result, HttpStatus.OK);
	        } 
			return new ResponseEntity<>(new Result("Error", "User name is required"), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Unexpected error: " + e.getMessage());
			return new ResponseEntity<>(new Result("Error", "An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-user/{userId}")
	public ResponseEntity<Result> getByUserID(@PathVariable Long userId) {
	    log.info("<<<<<<<<<<< start getByUserID() ");
	    try {
	    	Result userResult = userService.getByUserId(userId);
	        if (userResult != null) {
	            log.info(">>>>>>>>> end getByUserID() ");
	            return new ResponseEntity<>(userResult, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(new Result("Error", "User not found"), HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        log.error("Unexpected error: " + e.getMessage());
	        return new ResponseEntity<>(new Result("Error", "An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
