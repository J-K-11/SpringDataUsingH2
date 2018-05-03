package com.tech.springDataUsingH2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.tech.springDataUsingH2.domain.Employee;

public interface EmployeeService {
	public Employee findByName(String name);
	public List<Employee> findByDesignation(String designation);
	public int saveEmployee(Employee employee);
	public List<Employee> findAll();
	public void deleteEmployeee(Integer id);
	public Page<Employee> findAll(Pageable p);
	public List<Employee> findAll(Sort s);
	public List<Employee> findByNameAndDesignation(String name, String designation);
	public List<Employee>  findByAgeLessThan(int age);
	public List<Employee> findByNameStartingWith(String nameStartsWith);

}
