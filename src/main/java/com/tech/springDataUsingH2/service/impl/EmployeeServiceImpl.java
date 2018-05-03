package com.tech.springDataUsingH2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tech.springDataUsingH2.domain.Employee;
import com.tech.springDataUsingH2.repository.EmployeeRepository;
import com.tech.springDataUsingH2.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
	}

	@Override
	public int saveEmployee(Employee employee) {
		return employeeRepository.save(employee).getId();
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployeee(Integer id) {
		employeeRepository.delete(id);
		
	}

	@Override
	public Page<Employee> findAll(Pageable p) {
		return employeeRepository.findAll(p);
	}

	@Override
	public List<Employee> findAll(Sort s) {
		return employeeRepository.findAll(s);
	}

	@Override
	public List<Employee> findByNameAndDesignation(String name,
			String designation) {
		return employeeRepository.findByNameAndDesignation(name, designation);
	}

	@Override
	public List<Employee> findByAgeLessThan(int age) {
		return employeeRepository.findByAgeLessThan(age);
	}

	@Override
	public List<Employee> findByNameStartingWith(String nameStartsWith) {
		return employeeRepository.findByNameStartingWith(nameStartsWith);
	}

}
