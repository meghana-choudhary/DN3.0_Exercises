package com.code.employee.repository;

import java.util.List;

import com.code.employee.entity.Employee;

public interface EmployeeRepository {

	//derived query methods
	List<Employee> findByName(String name);
	List<Employee> findByDepartmentId(int departmentId);
	List<Employee> findByEmail(String email);
}
