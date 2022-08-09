package com.vishal.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vishal.crud.dao.EmployeeDAO;
import com.vishal.crud.pojo.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@GetMapping("/employeeHome")
	public String home(Model modelAndView,@RequestParam(required = false) Integer page) {
		List<Employee> users=employeeDAO.getAllEmployee();
		modelAndView.addAttribute("listOfEmployees", users);
		
		byte RECORDS_ON_ONE_PAGE=12;
		
		byte NUMBER_OF_PAGES=8;
		
		//---pagination-start
		//List<User> users = userService.getUsers();
        PagedListHolder<Employee> pagedListHolder = new PagedListHolder<>(users);
        pagedListHolder.setPageSize(RECORDS_ON_ONE_PAGE);
        int maxPage=pagedListHolder.getPageCount();
        modelAndView.addAttribute("maxPages",maxPage);
        
       System.out.println("pagedListHolder.getPageCount()="+pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())
        	page=1;

        modelAndView.addAttribute("page", page);
        
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addAttribute("users", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addAttribute("users", pagedListHolder.getPageList());
        }
        
        
        if(NUMBER_OF_PAGES>pagedListHolder.getPageCount()) {
        	NUMBER_OF_PAGES=(byte)pagedListHolder.getPageCount();
        }
        
        
        modelAndView.addAttribute("NUMBER_OF_PAGES", NUMBER_OF_PAGES);
        
        
        
        int lastPageInPagination=0;
        int firstPageInPagination=page/NUMBER_OF_PAGES;
     	firstPageInPagination=firstPageInPagination*NUMBER_OF_PAGES;
     	if(page!=firstPageInPagination)
     	{	
     		firstPageInPagination++;
     		lastPageInPagination=firstPageInPagination+NUMBER_OF_PAGES-1;
     	}else {
     		lastPageInPagination=firstPageInPagination;
     		firstPageInPagination=firstPageInPagination-NUMBER_OF_PAGES+1;
     		
     	}
     	
     	
     	if(lastPageInPagination>maxPage) {
     		lastPageInPagination=maxPage;
     	}
     	
        //int remainder=page%NUMBER_OF_PAGES;
        
        System.out.println("page="+page+"|firstPageInPagination="+firstPageInPagination+"|lastPageInPagination="+lastPageInPagination);
        
        modelAndView.addAttribute("lastPageInPagination", lastPageInPagination);
        modelAndView.addAttribute("firstPageInPagination", firstPageInPagination);
        
        //---pagination-end
		
		
		return "employee-home";
	}
	
	
	@GetMapping("/newemployee")
	public String newemployee(@ModelAttribute("empModel") Employee emp ) {
		//List<Employee> list=employeeDAO.getAllEmployee();
		//model.addAttribute("listOfEmployees", list);
		
		
		
		return "new-employee";
	}
	
	@PostMapping("/processEmp")
	public String processEmp(@ModelAttribute("empModel") Employee emp,BindingResult result) {
		//List<Employee> list=employeeDAO.getAllEmployee();
		//model.addAttribute("listOfEmployees", list);
		Employee emp1=null;
		if(emp.getId() ==0 ) {
		 emp1=employeeDAO.insert(emp);
		 }else {
			 emp1=employeeDAO.update(emp);
		 }
		System.out.println("Inserted=> "+emp1);
		
		return "redirect:employeeHome";
	}
	
	@GetMapping("/delete/{empid}")
	public String deleteemployee(@PathVariable("empid") String empid ) {
		System.out.println("deleteemployee|empid="+empid);
		
		return "redirect:/employeeHome";
	}
	

	@GetMapping("/edit/{empid}")
	public String editemployee(@PathVariable("empid") String empid ,Model model) {
		System.out.println("editemployee|empid="+empid);
		
		Employee e=employeeDAO.getEmployeeByID(Integer.parseInt(empid));
		
		model.addAttribute("empModel", e);
		
		return "new-employee";
	}
	
	
}
