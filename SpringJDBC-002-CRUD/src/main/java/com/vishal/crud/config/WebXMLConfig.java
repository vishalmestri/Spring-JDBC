package com.vishal.crud.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXMLConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Called getRootConfigClasses");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("Called getServletConfigClasses");
		Class[] classArray= {SpringMVCConfig.class};
		return classArray;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("Called getServletMappings");
		String array[]= {"/"};
		return array;
	}

}
