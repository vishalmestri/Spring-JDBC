package com.vishal.crud.pojo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vishal.crud.pojo.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Employee e =new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setGender(rs.getByte(3));
		e.setAddress(rs.getString(4));
		e.setStatus(rs.getByte(5));
		return e;
	}

}
