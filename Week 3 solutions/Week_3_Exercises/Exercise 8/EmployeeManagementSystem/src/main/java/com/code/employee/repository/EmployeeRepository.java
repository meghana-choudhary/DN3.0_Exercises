package com.code.employee.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.employee.entity.Department;
import com.code.employee.entity.Employee;
import com.code.employee.projection.EmployeeValueProjection;
import com.code.employee.projection.Employeeprojection;

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
	
	//Find all employees with pagination and sorting
	Page<Employee> findAll(org.springframework.data.domain.Pageable pageable);
	
	//Find employees by department with pagination and sorting
	Page<Employee> findByDepartment(int departmentId,Pageable pageable);
	//@Query("SELECT e.name as name,e.email as email FROM EMPLOYEE e")
	//List<EmployeeProjection> findByEmployee();

	Page<Employee> findByDepartmentId(int departmentId,Pageable pageable);
	
	
	//adding the query for employee projection
	@Query("SELECT e.name as name,e.salary as salary FROM Employee e")
	List<Employeeprojection> findByEmployee();
	
	//adding the query for employee projection by value
	@Query("SELECT e.name as name,e.salary as salary FROM Employee e WHERE e.department.name=:departmentName")
	List<EmployeeValueProjection> findByDepartmentName1(@Param("departmentName") String departmentName);
}
