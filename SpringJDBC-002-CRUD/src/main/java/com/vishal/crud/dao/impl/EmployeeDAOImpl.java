package com.vishal.crud.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.vishal.crud.dao.EmployeeDAO;
import com.vishal.crud.pojo.Employee;
import com.vishal.crud.pojo.mapper.EmployeeRowMapper;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		
		
		List<Employee> list=new ArrayList<>();
		
		
		list=jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper(Employee.class));
		
		/*
		Employee e1=new Employee();
		e1.setId(1);
		byte b=0;
		e1.setGender(b);
		e1.setAddress("address");
		e1.setName("vvvv");
		list.add(e1);
		
		
		Employee e2=new Employee();
		e2.setId(2);
		//byte b=0;
		e2.setGender(b);
		e2.setAddress("address22");
		e2.setName("vvvv22");
		list.add(e2);
		
		*/
		return list;
	}

	@Override
	public Employee insert(Employee e) {
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Object [] arr={e.getName(),e.getGender(),e.getAddress(),e.getStatus()} ;

//		jdbcTemplate.up
		
		jdbcTemplate.update(connection -> {
		    PreparedStatement ps = connection.prepareStatement("insert into employee(name,gender,address,status) values (?,?,?,?)", 
		                           Statement.RETURN_GENERATED_KEYS);
		    ps.setString(1, e.getName());
		    ps.setInt(2, e.getGender());
		    ps.setString(3, e.getAddress());
		    ps.setInt(4, 1);

		    return ps;
		},keyHolder);

		e.setId(keyHolder.getKey().intValue());
		return e;
	}

	@Override
	public Employee getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		

		Object[] arr= {id};
		
		Employee e=jdbcTemplate.queryForObject("select * from employee where id = ?",arr,new  EmployeeRowMapper());
		return e;
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		
		Object [] arr={e.getName(),e.getGender(),e.getAddress(),e.getStatus(),e.getId()} ;
		
		int count=jdbcTemplate.update("update employee set name=?,gender=?,address=?,status=? where id =?",arr);
		if(count!=1) {
			return null;
		}
		else
			return e;
	}

}
