package com.tech.springDataUsingH2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.springDataUsingH2.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>,
		PagingAndSortingRepository<Employee, Integer> {
	
	public Employee findByName(@Param("name")String name);
	public List<Employee> findByDesignation(String designation);
	public List<Employee> findByNameAndDesignation(String name, String designation);
	public List<Employee>  findByAgeLessThan(int age);
	public List<Employee> findByNameStartingWith(String nameStartsWith);
}
