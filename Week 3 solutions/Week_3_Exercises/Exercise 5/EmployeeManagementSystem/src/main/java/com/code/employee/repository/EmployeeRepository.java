package com.code.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.employee.entity.Department;
import com.code.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//Using the named query defined in Employee entity
	@Query(name="Employee.findByEmail")
	Employee findByEmailNamed(@Param("email")String email);
	//email is unique so we are not using List
	//in employee in email, unique=true
	
	//Using the named query defined in Employee entity
	@Query(name="Employee.findByDepartmentId")
	List<Employee> findByDepartmentIdNamed(@Param("departmentId")int departmentId);
	//under one department there can be many employees so we are using List
}
