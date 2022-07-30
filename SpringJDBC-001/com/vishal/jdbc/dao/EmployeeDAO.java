package com.vishal.jdbc.dao;
import org.springframework.stereotype.Component;

import com.vishal.jdbc.entity.Employee;

@Component
public interface EmployeeDAO {

	public int insert(Employee e);
}
