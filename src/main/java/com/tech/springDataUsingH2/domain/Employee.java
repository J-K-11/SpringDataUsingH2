package com.tech.springDataUsingH2.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findByName", query="SELECT e from Employee e where e.name=LOWER(:name)")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String designation;
private int age;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "employee", nullable = false, updatable = false)
private List<Address> addresses;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}

public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}


public List<Address> getAddresses() {
	return addresses;
}
public void setAddresses(List<Address> addresses) {
	this.addresses = addresses;
}
public Employee() {
	super();
}
public Employee(int id, String name, String designation, int age,
		List<Address> addresses) {
	super();
	this.id = id;
	this.name = name;
	this.designation = designation;
	this.age = age;
	this.addresses = addresses;
}



}
