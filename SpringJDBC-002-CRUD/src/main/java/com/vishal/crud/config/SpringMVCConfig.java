package com.vishal.crud.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.vishal"})
public class SpringMVCConfig  implements WebMvcConfigurer  {
	
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		System.out.println("addResourceHandlers called...");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resourceViewResolver= new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/view/jsp/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
	}
	
	@Autowired
	DataSource datasource;
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(datasource);
		
		
		return jdbcTemplate;
		
	}
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource("jdbc:mysql://localhost:3306/springjdbc?usessl=false","root","root");
		
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		
		return datasource;
		
	}

}
