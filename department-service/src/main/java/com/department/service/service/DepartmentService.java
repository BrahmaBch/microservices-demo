package com.department.service.service;

import com.department.service.dto.Result;
import com.department.service.entity.Department;

public interface DepartmentService {

    public Result saveDepartment(Department department);

	public Result findByDepartmentID(Long id);
}
