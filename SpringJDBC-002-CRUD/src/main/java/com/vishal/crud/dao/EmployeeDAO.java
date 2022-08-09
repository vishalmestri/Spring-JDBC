package com.vishal.crud.dao;

import java.util.List;

import com.vishal.crud.pojo.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployee();
	
	public Employee insert(Employee e);
	
	
	public Employee getEmployeeByID(int id);

	public Employee update(Employee emp);
}
