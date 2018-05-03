package com.tech.springDataUsingH2.controllers;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tech.springDataUsingH2.domain.Address;
import com.tech.springDataUsingH2.domain.Employee;
import com.tech.springDataUsingH2.dto.EmployeeDTO;
import com.tech.springDataUsingH2.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
	@ApiOperation(value = "Find employee by name")
	@RequestMapping(value="/findEmployeeByName", method=RequestMethod.GET)
	public Employee findEmployeeByName(@RequestParam("name") String name){
		return employeeService.findByName(name);
	}
	@ApiOperation(value = "Find employee by designation")
	@RequestMapping(value="/findEmployeeByDesignation", method=RequestMethod.GET)
	public List<Employee> findEmployeeByDesignation(@RequestParam("designation") String designation){
		return employeeService.findByDesignation(designation);
	}
	
	@ApiOperation(value = "Find employee by name and designation")
	@RequestMapping(value="/findEmployeeByNameAndDesignation", method=RequestMethod.GET)
	public List<Employee> findEmployeeByNameAndDesignation(@RequestParam("name") String name, @RequestParam("designation") String designation){
		return employeeService.findByNameAndDesignation(name, designation);
	}
	
	@ApiOperation(value = "Find employee by age less than")
	@RequestMapping(value="/findEmployeeByAgeLessThan", method=RequestMethod.GET)
	public List<Employee> findEmployeeByAgeLessThan(@RequestParam("age") Integer age){
		return employeeService.findByAgeLessThan(age);
	}
	
	@ApiOperation(value = "Find employee by name starting with")
	@RequestMapping(value="/findEmployeeByNameStartingWith", method=RequestMethod.GET)
	public List<Employee> findEmployeeByNameStartingWith(@RequestParam("nameStartingWith") String nameStartingWith){
		return employeeService.findByNameStartingWith(nameStartingWith);
	}
	
	@ApiOperation(value = "Add a new employee")
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST, produces="application/json")
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		Mapper dozer= new DozerBeanMapper();
		Employee employee = dozer.map(employeeDTO, Employee.class);
		return "Employee saved successfully with id:"+employeeService.saveEmployee(employee);
	}
	
	@ApiOperation(value = "Find all employees")
	@RequestMapping(value="/findAllEmployee", method=RequestMethod.GET)
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	@ApiOperation(value = "Find all employees with pagination")
	@RequestMapping(value="/findAllEmployeeWithPagination", method=RequestMethod.GET)
	public Page<Employee> findAllWithPagination(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize){
		PageRequest pr = new PageRequest(pageNumber, pageSize);
		return employeeService.findAll(pr);
	}
	
	@ApiOperation(value = "Find all employees with pagination")
	@RequestMapping(value="/findAllEmployeeWithOrdering", method=RequestMethod.GET)
	public List<Employee> findAllWithOrdering(@RequestParam("orderBy") String orderBy, @RequestParam("order")Direction order){
		Sort s= new Sort(new Sort.Order(order, orderBy));
		return employeeService.findAll(s);
	}
	
	@ApiOperation(value = "Find all employees with pagination and sorting")
	@RequestMapping(value="/findAllEmployeeWithOrderingAndPaging", method=RequestMethod.GET)
	public Page<Employee> findAllWithPaginationAndSorting(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize, @RequestParam("orderBy") String orderBy, @RequestParam("order")Direction order){
		Sort s= new Sort(new Sort.Order(order, orderBy));
		PageRequest pr = new PageRequest(pageNumber, pageSize, s);
		return employeeService.findAll(pr);
	}
	
	@ApiOperation(value = "Delete employee by id")
	@RequestMapping(value="/deleteEmployee", method=RequestMethod.DELETE)
	public String deleteEmployee(@RequestParam("id") Integer id){
		employeeService.deleteEmployeee(id);
		return "Employee deleted successfully";
		
	}
}
