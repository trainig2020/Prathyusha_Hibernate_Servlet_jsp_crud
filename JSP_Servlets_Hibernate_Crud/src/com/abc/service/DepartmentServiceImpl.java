package com.abc.service;

import java.util.List;

import com.abc.dao.DepartmentDao;
import com.abc.dao.DepartmentDaoImpl;
import com.abc.model.Department;

import java.util.List;


public class DepartmentServiceImpl implements DepartmentService{
	
	DepartmentDao dao = new DepartmentDaoImpl();

	

	@Override
	public void insertDepartment(Department dept) {
		 dao.insertDepartment(dept);
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return dao.getAllDepartments();
	}

	@Override
	public String updateDepartment(Department dept) {
		return dao.updateDepartment(dept);
	}

	@Override
	public void deleteDepartment(int deptId) {
		 dao.deleteDepartment(deptId);
	}

	@Override
	public Department getDeptById(int deptId) {
		
		return dao.getDeptById(deptId);
	}


}