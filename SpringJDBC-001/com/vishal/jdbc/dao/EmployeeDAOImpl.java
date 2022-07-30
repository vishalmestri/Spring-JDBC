package com.vishal.jdbc.dao;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.vishal.jdbc.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	
	JdbcTemplate jdbcTemplate=new JdbcTemplate(getDatasource());
	
	
	@Override
	public int insert(Employee e) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO EMPLOYEE (ID, NAME, GENDER) VALUES (?,?,?)";
		
		System.out.println("rached ");
		Object ars[]= {e.getId(),e.getName(),e.getGender()};
		int i= jdbcTemplate.update(sql, ars);
		return i;
	}
	
	
	private DataSource getDatasource() {
		DataSource dataSource;
		
		dataSource=new DriverManagerDataSource("jdbc:mysql://localhost:3306/springjdbc?usessl=false", "root", "root");
		
		return dataSource;
	}
	

}
