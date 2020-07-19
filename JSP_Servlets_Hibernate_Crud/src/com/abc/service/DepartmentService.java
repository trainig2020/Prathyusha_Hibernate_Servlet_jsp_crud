package com.abc.service;

import java.util.List;

import com.abc.dao.DepartmentDao;
import com.abc.dao.DepartmentDaoImpl;
import com.abc.model.Department;


import java.util.List;

public interface DepartmentService {

	
	public void insertDepartment(Department dept);
	public List<Department> getAllDepartments();
	public String updateDepartment(Department dept);
	public void deleteDepartment(int deptId);
	public Department getDeptById(int deptId);


}