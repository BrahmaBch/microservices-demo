package com.department.service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.department.service.dto.Result;
import com.department.service.entity.Department;
import com.department.service.service.DepartmentService;

@RestController
@Slf4j
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping("/getString")
	public String getString() {
		return "getString method called";
	}

	@PostMapping("/save-department")
	public ResponseEntity<Result> saveDepartment(@RequestBody Department department) {
		log.info("<<<<<<<<<<<  start saveDepartment() ");
		try {
			if (department.getDepartmentName() != null || !department.getDepartmentName().isEmpty()) {
				Result result = departmentService.saveDepartment(department);
				log.info(">>>>>>>>> end saveDepartment() ");
				return new ResponseEntity<>(result, HttpStatus.OK);
	        } 
			return new ResponseEntity<>(new Result("Error", "Department name is required"), HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			log.error("Unexpected error: " + e.getMessage());
			return new ResponseEntity<>(new Result("Error", "An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get-department/{id}")
	public ResponseEntity<Result> getByDepartmentID(@PathVariable Long id) {
	    log.info("<<<<<<<<<<< start getByDepartmentID() ");
	    try {
	    	Result departmentResult = departmentService.findByDepartmentID(id);
	        if (departmentResult != null) {
	            log.info(">>>>>>>>> end getByDepartmentID() ");
	            return new ResponseEntity<>(departmentResult, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(new Result("Error", "Department not found"), HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        log.error("Unexpected error: " + e.getMessage());
	        return new ResponseEntity<>(new Result("Error", "An unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
