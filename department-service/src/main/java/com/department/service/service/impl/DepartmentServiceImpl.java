package com.department.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.department.service.dao.DepartmentDAO;
import com.department.service.dto.Result;
import com.department.service.entity.Department;
import com.department.service.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public Result saveDepartment(Department department) {
        Department department1 = departmentDAO.save(department);
        Result result = new Result();
        result.setData(department1);
        result.setStatusCode(HttpStatus.OK.value());
        result.setSuccesMessage("Department saved successfully");
        return result;
    }

	@Override
	public Result findByDepartmentID(Long id) {
		 Department department1 = departmentDAO.findByDepartmentId(id);
	        Result result = new Result();
	        result.setData(department1);
	        result.setStatusCode(HttpStatus.OK.value());
	        result.setSuccesMessage("Department saved successfully");
        return result;
	}
}
