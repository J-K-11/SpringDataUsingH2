package com.tech.springDataUsingH2.dto;

import java.util.List;

import com.tech.springDataUsingH2.domain.Address;

public class EmployeeDTO {

	private String name;
	private String designation;
	private int age;
	private List<AddressDTO> addresses;
	
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
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	
}
