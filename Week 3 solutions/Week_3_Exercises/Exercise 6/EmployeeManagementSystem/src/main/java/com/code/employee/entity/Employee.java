package com.code.employee.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="employees")
@Getter
@Setter
@NamedQueries({
	@NamedQuery(
			name="Employee.findByEmail",
			query="SELECT e FROM Employee e WHERE e.email=:email"
			),
	@NamedQuery(
			name="Employee.findByDepartmentId",
			query="SELECT e FROM Employee e WHERE e.department.id=:departmentId"
			//show all the employees that work in that particular department that matches the id in each table
			//call it in EmployeeRepository by its name since it is a namedquery
			)
	
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="email",nullable = false, unique = true)
    private String email;
    
    @Column(name="salary",nullable = false)
    private double salary;
    //relationship with department one employee can works in one department
    //under one department there will be many employees
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    //creating a foreign key deptid red to the PrimaryKey of the department
}