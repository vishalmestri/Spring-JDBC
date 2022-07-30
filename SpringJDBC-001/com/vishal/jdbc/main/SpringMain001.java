package com.vishal.jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.vishal.jdbc.dao.EmployeeDAO;
import com.vishal.jdbc.entity.Employee;

public class SpringMain001 {

	
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
		
		Employee e= new Employee();
		e.setId(3);
		e.setName("Vishal-"+e.getId());
		e.setGender(0);
		EmployeeDAO employeeDAO=(EmployeeDAO) applicationContext.getBean("EmployeeDAO");
		int i=employeeDAO.insert(e);
		System.out.println("i="+i);
		
	}
}
