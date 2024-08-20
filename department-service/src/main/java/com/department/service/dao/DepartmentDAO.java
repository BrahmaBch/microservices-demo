package com.department.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.department.service.entity.Department;


@Repository
public interface DepartmentDAO extends JpaRepository<Department, Long> {
	
	Department findByDepartmentId(Long departmentId);

}
