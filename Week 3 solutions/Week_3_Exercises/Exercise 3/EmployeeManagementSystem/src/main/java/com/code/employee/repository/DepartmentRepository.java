package com.code.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.employee.entity.Department;
import com.code.employee.entity.Employee;

public interface DepartmentRepository extends JpaRepository<Employee, Integer> {

	//Derived query methods
	Department findByName(String name);//not written any query by ourself
}
